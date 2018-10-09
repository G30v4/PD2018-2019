package com.distribuida.principal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.distribuida.config.Spring01Config;
import com.distribuida.servicios.ServicioOperaciones;

public class ContenerJavaMain {

	public static void main(String[] args) {
		
		ApplicationContext context = 
			new AnnotationConfigApplicationContext( Spring01Config.class ); 
		
		ServicioOperaciones servicio = 
			context.getBean( "servicioOp1", ServicioOperaciones.class );
		
		int respuesta = servicio.sumar( 2,  6 );
		
		System.out.printf( "La suma es: %d", respuesta );
	}

}
