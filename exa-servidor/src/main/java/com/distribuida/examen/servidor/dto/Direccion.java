package com.distribuida.examen.servidor.dto;

import java.io.Serializable;

public class Direccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String calle1;
	private String calle2;
	private String numero;
	
	public String getCalle1() {
		return calle1;
	}
	public void setCalle1(String calle1) {
		this.calle1 = calle1;
	}
	public String getCalle2() {
		return calle2;
	}
	public void setCalle2(String calle2) {
		this.calle2 = calle2;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}
