package com.distribuida.examen.web.actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.distribuida.examen.servidor.dto.Persona;
import com.distribuida.examen.servidor.servicios.ServicioPersonas;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author jsalvador
 *
 */
@Namespace("/")
@Result(name="ok", location="personas.jsp")
@Action("home")
public class HomeAction {

	@Getter @Setter protected List<Persona> personas;
	
	//---------------------------------------------------------------------
	// @Autowired==>plugin struts2-spring, necesita el setXxxxx
	
	@Setter private ServicioPersonas servicioPersonas;
	//---------------------------------------------------------------------
	
	public String execute( ) {
		
		// recuperar con CONTEXT de Spring
//		ServletContext servletContext = ServletActionContext.getServletContext();	
//		ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext( servletContext );	
//		ServicioPersonas servicio =  context.getBean( ServicioPersonas.class );
//		personas = servicio.list( );
		
		personas = servicioPersonas.list( );
		
		return "ok";
	}
}
