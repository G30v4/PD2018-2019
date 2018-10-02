package com.distribuida.ejb.servicios;

import javax.ejb.Remote;

@Remote
public interface ServicioOperaciones {

	public int sumar(int n1, int n2);
}
