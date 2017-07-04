package py.gov.asuncion.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import py.gov.asuncion.constant.ViewConstant;
import py.gov.asuncion.service.TipoLugarService;

/**
 *
 * @author vinsfran
 */
@Controller
//@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/dashboard")
public class DashboardController {


    /**
     *
     */
    public static final Log LOG = LogFactory.getLog(DashboardController.class);

    @Autowired
    @Qualifier("tipoLugarServiceImpl")
    private TipoLugarService tipoLugarService;

//    @GetMapping("/")
//    public RedirectView redirect() {
//        return new RedirectView(DASHBOARD_VIEW);
//    }
    @GetMapping({"/"})
    public ModelAndView showIndex(Model model) {
        ModelAndView mav = new ModelAndView(ViewConstant.DASHBOARD_VIEW);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mav.addObject("username", user.getUsername() + " 1");
        return mav;
    }

    @GetMapping("/tables")
    public String showTables(Model model) {
        return ViewConstant.TABLES_VIEW;
    }
    
    @GetMapping("/tiposlugares")
    public String redirect() {
//        return new RedirectView("tipolugar/list");
        return "redirect:/tipolugar/list";
    }

//    @GetMapping("/tipolugar")
//    public ModelAndView showTiposLugares(@RequestParam(name = "mensaje", required = false) String mensaje,
//            @RequestParam(name = "classmensaje", required = false) String classmensaje) {
//        ModelAndView mav = new ModelAndView(ViewConstant.ADMIN_TIPO_LUGAR_LIST);
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        mav.addObject("username", user.getUsername() + " 1");
//        mav.addObject("tiposlugares", tipoLugarService.listAllTiposLugares());
//        mav.addObject("mensaje", mensaje);
//        mav.addObject("classmensaje", classmensaje);
//        return mav;
//    }

}
