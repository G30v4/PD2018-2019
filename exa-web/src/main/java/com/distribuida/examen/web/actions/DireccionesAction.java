package com.distribuida.examen.web.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.jms.core.JmsTemplate;

import com.distribuida.examen.servidor.dto.Direccion;
import com.distribuida.examen.servidor.dto.DireccionDto;
import com.distribuida.examen.servidor.servicios.ServicioDirecciones;
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
	  @Result(name="direcciones", location="direcciones.jsp"),
	  @Result(name="home", location="/home.action", type="redirect"),
	})
public class DireccionesAction {

	@Getter @Setter private Integer id;
	@Getter @Setter private String nombre;
	@Getter @Setter private Direccion direccion;
	
	//---------------------------------------------------------------------
	// @Autowired==>plugin struts2-spring, necesita el setXxxxx
	
	@Setter private JmsTemplate jmsTemplate;
	@Setter private ServicioDirecciones servicioDirecciones;
	@Setter private ServicioPersonas servicioPersonas;
	//---------------------------------------------------------------------
	
	@Action(value="direcciones")
	public String direcciones( ) {
		
		// sincronico
		direccion = servicioDirecciones.find( id );
		
		nombre = servicioPersonas.find( id ).getNombre( );
		
		return "direcciones";
	}
	
	@Action(value="direccionGuardar")
	public String direccionGuardar( ) {
		
		//--asincronico
		DireccionDto dto = new DireccionDto();
		
		dto.setPersonaId( id );
		dto.setDireccion( direccion );
		
		jmsTemplate.convertAndSend( "/queue/direccion.insert", dto  );

		return "home";
	}
	
	@Action(value="direccionEliminar")
	public String direccionEliminar( ) {
		
		//--sincronico
		//servicioPersonas.delete( id );
		
		//--asincronico
		jmsTemplate.convertAndSend( "/queue/direccion.delete", id  );

		return "home";
	}
}
