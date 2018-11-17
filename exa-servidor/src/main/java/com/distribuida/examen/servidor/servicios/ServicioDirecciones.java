package com.distribuida.examen.servidor.servicios;

import com.distribuida.examen.servidor.dto.Direccion;

/**
 * 
 * @author jsalvador
 *
 */
public interface ServicioDirecciones {

	public Direccion find( int personaId );
	
	public void update( int personaId, Direccion p );
	public void delete( int personaId );
}
