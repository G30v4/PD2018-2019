package com.distribuida.examen.servidor.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author jsalvador
 *
 */
public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private int id;
	@Getter @Setter private String identificacion;
	@Getter @Setter private String nombre;
	@Getter @Setter private Date fechaNacimiento;
	
	@Getter @Setter private Direccion direccion = new Direccion( );
}
