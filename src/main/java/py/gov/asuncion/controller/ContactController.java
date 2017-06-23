package py.gov.asuncion.controller;

import py.gov.asuncion.constant.ViewConstant;
import py.gov.asuncion.model.ContactModel;
import py.gov.asuncion.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author vinsfran
 */
@Controller
//@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/contacts")
public class ContactController {

    /**
     *
     */
    public static final Log LOG = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("contactServiceImpl")
    private ContactService contactService;

    /**
     *
     * @return
     */
    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/contacts/showcontacts";
    }

    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    // @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
    // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    // @PreAuthorize("permitAll()")

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/contactform")
    public String redirectContactForm(@RequestParam(name = "id", required = false) int id,
            Model model) {
        ContactModel contactModel = new ContactModel();
        if (id != 0) {
            contactModel = contactService.findContactModelById(id);
        }
        model.addAttribute("contactModel", contactModel);
        return ViewConstant.CONTACT_FORM;
    }

    /**
     *
     * @param contactModel
     * @param model
     * @return
     */
    @PostMapping("/addcontact")
    public String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel,
            Model model) {
        LOG.info("METHOD: addContact() -- PARAMS: " + contactModel.toString());

        if (contactService.addContact(contactModel) != null) {
            model.addAttribute("result", 1);
        } else {
            model.addAttribute("result", 0);
        }

        return "redirect:/contacts/showcontacts";
    }

    /**
     *
     * @return
     */
    @GetMapping("/showcontacts")
    public ModelAndView showContacts() {
        ModelAndView mav = new ModelAndView(ViewConstant.CONTACTS);
        
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername() + " 1");
        mav.addObject("contacts", contactService.listAllContacts());
        return mav;
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/removecontact")
    public ModelAndView removeContact(@RequestParam(name = "id", required = true) int id) {
        contactService.removeContact(id);
        return showContacts();
    }
}
