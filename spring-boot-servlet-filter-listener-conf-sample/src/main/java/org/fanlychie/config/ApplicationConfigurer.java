package org.fanlychie.config;

import org.fanlychie.web.CustomFilter;
import org.fanlychie.web.CustomListener;
import org.fanlychie.web.CustomServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by fanlychie on 2017/7/2.
 */
@Configuration
public class ApplicationConfigurer {

    @Bean
    public FilterRegistrationBean registerCustomFilter() {
        FilterRegistrationBean filterRegBean = new FilterRegistrationBean(new CustomFilter());
        filterRegBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegBean;
    }

    @Bean
    public ServletRegistrationBean registerCustomServlet() {
        ServletRegistrationBean servletRegBean = new ServletRegistrationBean(new CustomServlet());
        servletRegBean.setUrlMappings(Arrays.asList("/customServlet"));
        servletRegBean.setLoadOnStartup(1);
        return servletRegBean;
    }

    @Bean
    public ServletListenerRegistrationBean<?> registerCustomListener() {
        return new ServletListenerRegistrationBean<>(new CustomListener());
    }

}