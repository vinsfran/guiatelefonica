package py.gov.asuncion.configuration;

import py.gov.asuncion.component.RequestTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author vinsfran
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{

    @Autowired
    @Qualifier("requestTimeInterceptor")
    private RequestTimeInterceptor requestTimeInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestTimeInterceptor);
        registry.addInterceptor(new ThymeleafLayoutInterceptor());
    }
    
    
    
}
