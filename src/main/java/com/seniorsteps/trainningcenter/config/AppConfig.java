package com.seniorsteps.trainningcenter.config;

/**
 *
 * @author Remon
 */

import com.seniorsteps.trainningcenter.converter.CourseConverter;

import com.seniorsteps.trainningcenter.converter.RoleToUserRoleConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.seniorsteps.trainningcenter")
public class AppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private RoleToUserRoleConverter roleToUserRoleConverter;
    
    @Autowired
    private CourseConverter courseConverter;



    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        
        registry.addConverter(roleToUserRoleConverter);
        registry.addConverter(courseConverter);

    }
 
    
    

}
