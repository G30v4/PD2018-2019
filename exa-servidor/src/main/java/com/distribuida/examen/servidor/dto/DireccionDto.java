package com.distribuida.examen.servidor.dto;

import java.io.Serializable;

public class DireccionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int personaId;
	private Direccion direccion;
	
	public int getPersonaId() {
		return personaId;
	}
	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
}
