package py.gov.asuncion.controller;

import py.gov.asuncion.constant.ViewConstant;
import py.gov.asuncion.service.LugarService;
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
import py.gov.asuncion.model.LugarModel;
import py.gov.asuncion.service.TipoLugarService;

/**
 *
 * @author vinsfran
 */
@Controller
//@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/lugar")
public class LugarController {

    public static final Log LOG = LogFactory.getLog(LugarController.class);

    @Autowired
    @Qualifier("lugarServiceImpl")
    private LugarService lugarService;

    @Autowired
    @Qualifier("tipoLugarServiceImpl")
    private TipoLugarService tipoLugarService;

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/" + ViewConstant.LUGAR_LIST;
    }

    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    // @PreAuthorize("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
    // @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    // @PreAuthorize("permitAll()")
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/form")
    public String redirectLugarForm(@RequestParam(name = "id", required = false) int id,
            Model model) {
        LugarModel lugarModel = new LugarModel();
        if (id != 0) {
            lugarModel = lugarService.findLugarModelById(id);
        }
        model.addAttribute("lugarmodel", lugarModel);
        model.addAttribute("tiposlugares", tipoLugarService.listAllTiposLugares());
        return ViewConstant.LUGAR_FORM;
    }

    @PostMapping("/add")
    public ModelAndView addLugar(@ModelAttribute(name = "lugarModel") LugarModel lugarModel) {
        LOG.info("METHOD: addLugar() -- PARAMS: " + lugarModel.toString());
        ModelAndView mav = new ModelAndView(ViewConstant.LUGAR_LIST);
        if (lugarService.addLugar(lugarModel) != null) {
            LOG.info("METHOD: addLugar() -- result: " + 1);
            mav.addObject("result", 1);
            return showLugares("Agregado Correctamente!", "alert alert-success");
        } else {
            LOG.info("METHOD: addLugar() -- result: " + 0);
            mav.addObject("result", 0);
            return showLugares("Error agregando Tipo de Lugar!", "alert alert-danger");
        }
//        return "redirect:/" + ViewConstant.TIPO_LUGAR_LIST;
//        return mav;
    }

    @GetMapping({"/", "/list"})
    public ModelAndView showLugares(@RequestParam(name = "mensaje", required = false) String mensaje,
            @RequestParam(name = "classmensaje", required = false) String classmensaje) {
        ModelAndView mav = new ModelAndView(ViewConstant.LUGAR_LIST);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername() + " 1");
        for (LugarModel tm : lugarService.listAllLugares()) {
            LOG.info("METHOD: showLugares() -- PARAMS: " + tm.toString());

        }
        mav.addObject("lugares", lugarService.listAllLugares());
        mav.addObject("mensaje", mensaje);
        mav.addObject("classmensaje", classmensaje);
        return mav;
    }

    @GetMapping("/remove")
    public ModelAndView removeLugar(@RequestParam(name = "id", required = true) int id) {
        lugarService.removeLugar(id);
        return showLugares("Tipo de Lugar eliminado!", "alert alert-info");
    }
}
