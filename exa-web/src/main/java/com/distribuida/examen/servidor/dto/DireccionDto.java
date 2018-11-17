package com.distribuida.examen.servidor.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class DireccionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter @Setter private int personaId;
	@Getter @Setter private Direccion direccion;	
}
