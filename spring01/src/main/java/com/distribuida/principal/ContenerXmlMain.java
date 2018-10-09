package com.distribuida.principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.distribuida.servicios.ServicioOperaciones;

public class ContenerXmlMain {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext( "app.xml" ); 
		
		ServicioOperaciones servicio = context.getBean( ServicioOperaciones.class );
		
		int respuesta = servicio.sumar( 2,  6 );
		
		System.out.printf( "La suma es: %d", respuesta );
	}

}
