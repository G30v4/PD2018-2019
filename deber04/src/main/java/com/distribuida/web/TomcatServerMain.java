package com.distribuida.web;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import com.distribuida.web.servlets.TestServlet;

public class TomcatServerMain {

	public static final int PORT = 8080;
	
	public static void main( String args[ ] ) throws LifecycleException {
		
		String webappDirLocation = "src/main/webapp/";
		
        Tomcat tomcat = new Tomcat();
        
        tomcat.setPort( PORT );
        
        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
        
        System.out.println("Base path: " + new File("./" + webappDirLocation).getAbsolutePath());
        
        
        // Servlet agregado manualmente
        Tomcat.addServlet( ctx, "TestServlet", new TestServlet() );
        ctx.addServletMappingDecoded( "/test", "TestServlet" );
        
        // El directorio 'bin' es el directorio de compilacion dle proyecto
        File additionWebInfClasses = new File("bin");
        
        WebResourceRoot resources = new StandardRoot(ctx);
        
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",additionWebInfClasses.getAbsolutePath(), "/"));
        
        ctx.setResources(resources);
        
        // iniciar el servidor
        
        tomcat.start();
        
        tomcat.getServer().await();

	}
}
