package com.distribuida.examen.servidor.servicios;

import java.util.List;

import com.distribuida.examen.servidor.dto.Persona;

/**
 * 
 * @author jsalvador
 *
 */
public interface ServicioPersonas {

	public List<Persona> list( );
	public Persona find( int id );
	
	public void insert( Persona p );
	public void update( Persona p );
	public void delete( int id );
}
