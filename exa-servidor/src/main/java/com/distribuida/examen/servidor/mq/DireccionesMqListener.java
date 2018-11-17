package com.distribuida.examen.servidor.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.distribuida.examen.servidor.dto.DireccionDto;
import com.distribuida.examen.servidor.servicios.ServicioDirecciones;

@Component
public class DireccionesMqListener {
	
	@Autowired private ServicioDirecciones servicioDirecciones;
	
	@JmsListener(destination="/queue/direccion.insert", containerFactory="jmsListenerContainerFactory")
	public void insertPersona( DireccionDto dto ) {
		
		System.out.println( "INSERT direccion" );
		
		servicioDirecciones.update( dto.getPersonaId(), dto.getDireccion( ) );
		
	}
	
	@JmsListener(destination="/queue/direccion.update", containerFactory="jmsListenerContainerFactory")
	public void updatePersona( DireccionDto dto ) {
		
		System.out.println( "UPDATE direccion" );
		
		servicioDirecciones.update( dto.getPersonaId(), dto.getDireccion( ) );
	}

	@JmsListener(destination="/queue/direccion.delete", containerFactory="jmsListenerContainerFactory")
	public void deletePersona( Integer personaId ) {
		
		System.out.println( "DELETE direccion" );
		
		servicioDirecciones.delete( personaId );
		
	}
}
