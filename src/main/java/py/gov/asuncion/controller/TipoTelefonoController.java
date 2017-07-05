package py.gov.asuncion.controller;

import py.gov.asuncion.constant.ViewConstant;
import py.gov.asuncion.service.TipoTelefonoService;
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
import py.gov.asuncion.model.TipoTelefonoModel;

/**
 *
 * @author vinsfran
 */
@Controller
//@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/tipotelefono")
public class TipoTelefonoController {

    public static final Log LOG = LogFactory.getLog(TipoTelefonoController.class);

    @Autowired
    @Qualifier("tipoTelefonoServiceImpl")
    private TipoTelefonoService tipoTelefonoService;

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/" + ViewConstant.TIPO_TELEFONO_LIST;
    }

    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    // @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
    // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    // @PreAuthorize("permitAll()")
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/form")
    public String redirectTipoTelefonoForm(@RequestParam(name = "id", required = false) int id,
            Model model) {
        TipoTelefonoModel tipoTelefonoModel = new TipoTelefonoModel();
        if (id != 0) {
            tipoTelefonoModel = tipoTelefonoService.findTipoTelefonoModelById(id);
        }
        model.addAttribute("tipotelefonomodel", tipoTelefonoModel);
        return ViewConstant.TIPO_TELEFONO_FORM;
    }

    @PostMapping("/add")
    public ModelAndView addTipoTelefono(@ModelAttribute(name = "tipolugarmodel") TipoTelefonoModel tipoTelefonoModel) {
        LOG.info("METHOD: addTipoTelefono() -- PARAMS: " + tipoTelefonoModel.toString());
        ModelAndView mav = new ModelAndView(ViewConstant.TIPO_TELEFONO_LIST);
        if (tipoTelefonoService.addTipoTelefono(tipoTelefonoModel) != null) {
            LOG.info("METHOD: addTipoTelefono() -- result: " + 1);
            mav.addObject("result", 1);
            return showTiposTelefonos("Agregado Correctamente!", "alert alert-success");
        } else {
            LOG.info("METHOD: addTipoTelefono() -- result: " + 0);
            mav.addObject("result", 0);
            return showTiposTelefonos("Error agregando Tipo de Telefono!", "alert alert-danger");
        }
//        return "redirect:/" + ViewConstant.TIPO_TELEFONO_LIST;
//        return mav;
    }

    @GetMapping({"/", "/list"})
    public ModelAndView showTiposTelefonos(@RequestParam(name = "mensaje", required = false) String mensaje,
            @RequestParam(name = "classmensaje", required = false) String classmensaje) {
        ModelAndView mav = new ModelAndView(ViewConstant.TIPO_TELEFONO_LIST);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername() + " 1");
        mav.addObject("tipostelefonos", tipoTelefonoService.listAllTiposTelefonos());
        mav.addObject("mensaje", mensaje);
        mav.addObject("classmensaje", classmensaje);
        return mav;
    }

    @GetMapping("/remove")
    public ModelAndView removeTipoTelefono(@RequestParam(name = "id", required = true) int id) {
        tipoTelefonoService.removeTipoTelefono(id);
        return showTiposTelefonos("Tipo de Telefono eliminado!", "alert alert-info");
    }
}
