package py.gov.asuncion.controller;

import py.gov.asuncion.constant.ViewConstant;
import py.gov.asuncion.service.TipoLugarService;
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
import py.gov.asuncion.model.TipoLugarModel;

/**
 *
 * @author vinsfran
 */
@Controller
//@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/tipolugar")
public class TipoLugarController {

    public static final Log LOG = LogFactory.getLog(TipoLugarController.class);

    @Autowired
    @Qualifier("tipoLugarServiceImpl")
    private TipoLugarService tipoLugarService;

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/" + ViewConstant.TIPO_LUGAR_LIST;
    }

    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    // @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
    // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    // @PreAuthorize("permitAll()")
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/form")
    public String redirectTipoLugarForm(@RequestParam(name = "id", required = false) int id,
            Model model) {
        TipoLugarModel tipoLugarModel = new TipoLugarModel();
        if (id != 0) {
            tipoLugarModel = tipoLugarService.findTipoLugarModelById(id);
        }
        model.addAttribute("tipolugarmodel", tipoLugarModel);
        return ViewConstant.TIPO_LUGAR_FORM;
    }

    @PostMapping("/add")
    public ModelAndView addTipoLugar(@ModelAttribute(name = "tipolugarmodel") TipoLugarModel tipoLugarModel) {
        LOG.info("METHOD: addTipoLugar() -- PARAMS: " + tipoLugarModel.toString());
        ModelAndView mav = new ModelAndView(ViewConstant.TIPO_LUGAR_LIST);
        if (tipoLugarService.addTipoLugar(tipoLugarModel) != null) {
            LOG.info("METHOD: addTipoLugar() -- result: " + 1);
            mav.addObject("result", 1);
            return showTiposLugares("Agregado Correctamente!", "alert alert-success");
        } else {
            LOG.info("METHOD: addTipoLugar() -- result: " + 0);
            mav.addObject("result", 0);
            return showTiposLugares("Error agregando Tipo de Lugar!", "alert alert-danger");
        }
//        return "redirect:/" + ViewConstant.TIPO_LUGAR_LIST;
//        return mav;
    }

    @GetMapping("/list")
    public ModelAndView showTiposLugares(@RequestParam(name = "mensaje", required = false) String mensaje,
            @RequestParam(name = "classmensaje", required = false) String classmensaje) {
        ModelAndView mav = new ModelAndView(ViewConstant.TIPO_LUGAR_LIST);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername() + " 1");
        mav.addObject("tiposlugares", tipoLugarService.listAllTiposLugares());
        mav.addObject("mensaje", mensaje);
        mav.addObject("classmensaje", classmensaje);
        return mav;
    }

    @GetMapping("/remove")
    public ModelAndView removeTipoLugar(@RequestParam(name = "id", required = true) int id) {
        tipoLugarService.removeTipoLugar(id);
        return showTiposLugares("Tipo de Lugar eliminado!", "alert alert-info");
    }
}
