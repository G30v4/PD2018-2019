package com.distribuida.examen.servidor.dto;

import java.io.Serializable;
import java.util.Date;

public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String identificacion;
	private String nombre;
	private Date fechaNacimiento;
	
	private Direccion direccion = new Direccion( );

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
