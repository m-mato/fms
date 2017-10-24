package com.mmajdis.fms.cofiguration;

import com.mmajdis.fms.controller.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Application web MVC configuration class.
 *
 * @author Matej Majdis [<a href="mailto:mato.majdis@gmail.com">mato.majdis@gmail.com</a>]
 */
@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);
    }
}
