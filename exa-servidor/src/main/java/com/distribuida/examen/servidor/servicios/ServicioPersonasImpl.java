package com.distribuida.examen.servidor.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.distribuida.examen.servidor.dto.Persona;

@Component
public class ServicioPersonasImpl implements ServicioPersonas {
	
	private List<Persona> personas = new ArrayList<>();
	
	private int nextId;
	
	@PostConstruct
	protected void init( ) {
		// inicializar
		
		Persona p = null;
		
		p = new Persona();
		p.setId( 1 );
		p.setIdentificacion( "1111" );
		p.setNombre( "Persona 1" );
		p.setFechaNacimiento( new Date( ) );
		personas.add( p );

		p = new Persona();
		p.setId( 2 );
		p.setIdentificacion( "2222" );
		p.setNombre( "Persona 2" );
		p.setFechaNacimiento( new Date( ) );
		personas.add( p );

		p = new Persona();
		p.setId( 3 );
		p.setIdentificacion( "3333" );
		p.setNombre( "Persona 3" );
		p.setFechaNacimiento( new Date( ) );
		personas.add( p );

		p = new Persona();
		p.setId( 4 );
		p.setIdentificacion( "4444" );
		p.setNombre( "Persona 4" );
		p.setFechaNacimiento( new Date( ) );
		personas.add( p );
		
		nextId = 5;
	}
			
	@Override
	public List<Persona> list() {

		return personas;
	}

	@Override
	public void insert(Persona p) {
	
		p.setId( nextId++ );
		personas.add( p );
	}
	
	public Persona find( int id ) {
		// buscar el elemento de la lista
		Optional<Persona> obj = personas.stream()
				.filter( o->o.getId()==id )
				.findFirst();
		
		if( obj.isPresent() ) {
			return obj.get( );
		}
		
		return null;
	}

	@Override
	public void update(Persona p) {
		
		// buscar el elemento de la lista
		Optional<Persona> obj = personas.stream()
				.filter( o->o.getId()==p.getId() )
				.findFirst();
		
		if( obj.isPresent() ) {
			obj.get().setNombre( p.getNombre( ) );
			obj.get().setIdentificacion( p.getIdentificacion() );
			obj.get().setFechaNacimiento( p.getFechaNacimiento() );
		}
	}

	@Override
	public void delete(int id) {
		Optional<Persona> obj = personas.stream()
				.filter( o->o.getId()==id )
				.findFirst();
		
		if( obj.isPresent() ) {
			personas.remove( obj.get() );
		}
	}
}
