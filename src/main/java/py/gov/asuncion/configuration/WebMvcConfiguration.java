package py.gov.asuncion.configuration;

import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.spring.JtwigViewResolver;
import org.jtwig.spring.asset.SpringAssetExtension;
import org.jtwig.web.servlet.JtwigRenderer;
import org.jtwig.spring.boot.config.JtwigViewResolverConfigurer;
import org.jtwig.spring.asset.resolver.AssetResolver;
import org.jtwig.spring.asset.resolver.BaseAssetResolver;
import py.gov.asuncion.component.RequestTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author vinsfran
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter implements JtwigViewResolverConfigurer {

    @Autowired
    @Qualifier("requestTimeInterceptor")
    private RequestTimeInterceptor requestTimeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestTimeInterceptor);
//        registry.addInterceptor(new ThymeleafLayoutInterceptor());
    }

    @Override
    public void configure(JtwigViewResolver viewResolver) {
        viewResolver.setRenderer(new JtwigRenderer(EnvironmentConfigurationBuilder.configuration()
                .extensions().add(new SpringAssetExtension()).and()
                .build()));
    }

    @Bean
    public AssetResolver assetResolver() {
        BaseAssetResolver assetResolver = new BaseAssetResolver();
        assetResolver.setPrefix("");
        return assetResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("static/**").addResourceLocations("classpath:/");
    }

}
