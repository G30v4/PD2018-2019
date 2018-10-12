package com.distribuida.servicios;

import org.springframework.stereotype.Component;

@Component(value="servicioOp1")
public class ServicioOperacionesImpl implements ServicioOperaciones {

	@Override
	public int sumar(int x, int y) {
		return x + y;
	}

}
