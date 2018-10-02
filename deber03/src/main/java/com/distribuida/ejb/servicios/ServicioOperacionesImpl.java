package com.distribuida.ejb.servicios;

import javax.ejb.Stateless;

@Stateless(mappedName="servicioOperaciones")
public class ServicioOperacionesImpl implements ServicioOperaciones {

	public int sumar( int n1, int n2 ) {
		
		System.out.printf( "Sumando dos numeros %d + %d", n1, n2 );
		
		return n1 + n2;
	}
}


