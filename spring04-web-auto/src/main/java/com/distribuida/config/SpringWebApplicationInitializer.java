package com.distribuida.config;

import javax.servlet.ServletContext;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class SpringWebApplicationInitializer implements WebApplicationInitializer {
	@Override
    public void onStartup(ServletContext servletContext) {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(Spring04Config.class);
        context.refresh();
        
        servletContext.addListener( new ContextLoaderListener(context) );
    }
}
