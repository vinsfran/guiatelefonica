package py.gov.asuncion.controller;

import py.gov.asuncion.constant.ViewConstant;
import py.gov.asuncion.service.TelefonoService;
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
import py.gov.asuncion.model.TelefonoModel;
import py.gov.asuncion.service.TipoTelefonoService;

/**
 *
 * @author vinsfran
 */
@Controller
//@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/telefono")
public class TelefonoController {

    public static final Log LOG = LogFactory.getLog(TelefonoController.class);

    @Autowired
    @Qualifier("telefonoServiceImpl")
    private TelefonoService telefonoService;

    @Autowired
    @Qualifier("tipoTelefonoServiceImpl")
    private TipoTelefonoService tipoTelefonoService;

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/" + ViewConstant.TELEFONO_LIST;
    }

    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    // @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
    // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    // @PreAuthorize("permitAll()")
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/form")
    public String redirectTelefonoForm(@RequestParam(name = "id", required = false) int id,
            Model model) {
        TelefonoModel telefonoModel = new TelefonoModel();
        if (id != 0) {
            telefonoModel = telefonoService.findTelefonoModelById(id);
        }
        model.addAttribute("telefonomodel", telefonoModel);
        model.addAttribute("tipostelefonos", tipoTelefonoService.listAllTiposTelefonos());
        return ViewConstant.TELEFONO_FORM;
    }

    @PostMapping("/add")
    public ModelAndView addTelefono(@ModelAttribute(name = "telefonoModel") TelefonoModel telefonoModel) {
        LOG.info("METHOD: addTelefono() -- PARAMS: " + telefonoModel.toString());
        ModelAndView mav = new ModelAndView(ViewConstant.TELEFONO_LIST);
        if (telefonoService.addTelefono(telefonoModel) != null) {
            LOG.info("METHOD: addTelefono() -- result: " + 1);
            mav.addObject("result", 1);
            return showTelefonos("Agregado Correctamente!", "alert alert-success");
        } else {
            LOG.info("METHOD: addTelefono() -- result: " + 0);
            mav.addObject("result", 0);
            return showTelefonos("Error agregando Tipo de Telefono!", "alert alert-danger");
        }
//        return "redirect:/" + ViewConstant.TIPO_TELEFONO_LIST;
//        return mav;
    }

    @GetMapping({"/", "/list"})
    public ModelAndView showTelefonos(@RequestParam(name = "mensaje", required = false) String mensaje,
            @RequestParam(name = "classmensaje", required = false) String classmensaje) {
        ModelAndView mav = new ModelAndView(ViewConstant.TELEFONO_LIST);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername() + " 1");
        for (TelefonoModel tm : telefonoService.listAllTelefonos()) {
            LOG.info("METHOD: showTelefonos() -- PARAMS: " + tm.toString());

        }
        mav.addObject("telefonos", telefonoService.listAllTelefonos());
        mav.addObject("mensaje", mensaje);
        mav.addObject("classmensaje", classmensaje);
        return mav;
    }

    @GetMapping("/remove")
    public ModelAndView removeTelefono(@RequestParam(name = "id", required = true) int id) {
        telefonoService.removeTelefono(id);
        return showTelefonos("Tipo de Telefono eliminado!", "alert alert-info");
    }
}
