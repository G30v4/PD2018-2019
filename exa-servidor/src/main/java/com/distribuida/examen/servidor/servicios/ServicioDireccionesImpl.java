package com.distribuida.examen.servidor.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.distribuida.examen.servidor.dto.Direccion;
import com.distribuida.examen.servidor.dto.Persona;

@Component
public class ServicioDireccionesImpl implements ServicioDirecciones {

	@Autowired private ServicioPersonas servicioPersonas;
	
	@Override
	public Direccion find( int personaId ) {
		Persona p = servicioPersonas.find( personaId );
		
		if( p!=null ) {
			return p.getDireccion( );
		}
		return null;
	}

	@Override
	public void update(int personaId, Direccion d) {
		Persona obj = servicioPersonas.find( personaId );
		
		if( obj!=null ) {
			obj.setDireccion( d );
		}
	}

	@Override
	public void delete( int personaId ) {
		Persona obj = servicioPersonas.find( personaId );
		
		if( obj!=null ) {
			obj.setDireccion( null );
		}
	}
}
