package py.gov.asuncion.controller;

import py.gov.asuncion.constant.ViewConstant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vinsfran
 */
@Controller
public class LoginController {

    /**
     *
     */
    public static final Log LOG = LogFactory.getLog(LoginController.class);

    /**
     *
     * @param model
     * @param error
     * @param logout
     * @return
     */
    @GetMapping("/login")
    public String showLoginForm(Model model,
            @RequestParam(name = "error", required = false) String error,
            @RequestParam(name = "logout", required = false) String logout) {
        LOG.info("METHOD: showLoginForm() -- PARAMS: error=" + error + ", logout=" + logout);
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        model.addAttribute("name", "hola mundo");
        LOG.info("Returning to login view");
        return ViewConstant.LOGIN;
    }

    /**
     *
     * @return
     */
    @GetMapping({"/loginsuccess", "/"})
    public String loginCheck() {
        LOG.info("METHOD: loginCheck()");
        LOG.info("Returning to contacts view");
        return "redirect:/contacts/showcontacts";
    }
}
