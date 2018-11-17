package com.distribuida.examen.servidor.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.distribuida.examen.servidor.dto.Persona;
import com.distribuida.examen.servidor.servicios.ServicioPersonas;

@Component
public class PersonasMqListener {
	
	@Autowired private ServicioPersonas servicio;
	
	@JmsListener(destination="/queue/personas.insert", containerFactory="jmsListenerContainerFactory")
	public void insertPersona( Persona persona ) {
		
		System.out.println( "INSERT persona" );
		
		servicio.insert( persona );
	}
	
	@JmsListener(destination="/queue/personas.update", containerFactory="jmsListenerContainerFactory")
	public void updatePersona( Persona persona ) {
		
		System.out.println( "UPDATE persona" );
		
		servicio.update( persona );
	}

	@JmsListener(destination="/queue/personas.delete", containerFactory="jmsListenerContainerFactory")
	public void deletePersona( Integer personaId ) {
		
		System.out.println( "DELETE persona" );
		
		servicio.delete( personaId );
	}
}
