package com.distribuida.examen.web.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * 
 * @author jsalvador
 *
 */
public class ExamenWebApplicationInitializer implements WebApplicationInitializer {
	@Override
    public void onStartup(ServletContext servletContext) {

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ExamenWebConfig.class);
        context.refresh();
        
        servletContext.addListener( new ContextLoaderListener(context) );
        
        // Struts filter
        StrutsPrepareAndExecuteFilter struts = new StrutsPrepareAndExecuteFilter( );
        FilterRegistration.Dynamic strutsFilter =  servletContext.addFilter( "struts2", struts );
        
        strutsFilter.addMappingForUrlPatterns( EnumSet.allOf(DispatcherType.class), false, "/*" );
    }
}
