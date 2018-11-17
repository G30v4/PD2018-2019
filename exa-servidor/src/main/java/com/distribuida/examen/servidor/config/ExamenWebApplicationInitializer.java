package com.distribuida.examen.servidor.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ExamenWebApplicationInitializer implements WebApplicationInitializer {
	@Override
    public void onStartup(ServletContext servletContext) {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ExamenServerConfig.class);
        context.refresh();
        
        //Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet( context );
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/app/*");
        
        servletContext.addListener( new ContextLoaderListener(context) );
    }
}
