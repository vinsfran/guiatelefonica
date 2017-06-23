package py.gov.asuncion.component;

import py.gov.asuncion.repository.LogRepository;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author vinsfran
 */
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    @Qualifier("logRepository")
    private LogRepository logRepository;

    /**
     *
     */
    public static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

    //PRIMERO
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    //SEGUNDO
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        String url = request.getRequestURL().toString();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        String details = "";
        if (auth != null && auth.isAuthenticated()) {
            username = auth.getName();
            details = auth.getDetails().toString();
            logRepository.save(new py.gov.asuncion.entity.Log(new Date(), details, username, url));
        }        
        LOG.info("Url to: '" + url + "' in: '" + (System.currentTimeMillis() - startTime) + "ms'");
    }

}
