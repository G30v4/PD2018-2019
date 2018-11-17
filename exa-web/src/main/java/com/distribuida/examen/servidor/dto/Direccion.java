package com.distribuida.examen.servidor.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author jsalvador
 *
 */
public class Direccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private String calle1;
	@Getter @Setter private String calle2;
	@Getter @Setter private String numero;
}
