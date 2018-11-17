package com.distribuida.examen.web.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.jms.core.JmsTemplate;

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
@Results({
	  @Result(name="nueva", location="personas-nueva.jsp"),
	  @Result(name="editar", location="personas-editar.jsp"),
	  @Result(name="home", location="/home.action", type="redirect"),
	})
public class PersonasAction {

	@Getter @Setter private Integer id;
	@Getter @Setter private Persona persona;
	
	//---------------------------------------------------------------------
	// @Autowired==>plugin struts2-spring, necesita el setXxxxx
	
	@Setter private JmsTemplate jmsTemplate;
	@Setter private ServicioPersonas servicioPersonas;
	//---------------------------------------------------------------------
	
	@Action(value="personaEditar")
	public String editar( ) {
		
		// sincronico
		persona = servicioPersonas.find( id );
		
		return "editar";
	}
	
	@Action(value="personaGuardar")
	public String personaGuardar( ) {
		
		//--asincronico
		if( persona.getId()==0 )
		{
			// nueva
			//servicioPersonas.insert( persona );
			jmsTemplate.convertAndSend( "/queue/personas.insert", persona  );
		}
		else
		{
			// actualizar
			//servicioPersonas.update( persona );
			jmsTemplate.convertAndSend( "/queue/personas.update", persona  );
		}

		return "home";
	}
	
	@Action(value="personaEliminar")
	public String personaEliminar( ) {
		
		//--sincronico
		//servicioPersonas.delete( id );
		
		//--asincronico
		jmsTemplate.convertAndSend( "/queue/personas.delete", id  );

		return "home";
	}
	
	@Action(value="personaNueva")
	public String nueva( ) {
		
		// sincronico
		persona = new Persona( );
		
		return "nueva";
	}
	
}
