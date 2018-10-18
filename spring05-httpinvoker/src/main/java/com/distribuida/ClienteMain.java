package com.distribuida;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.distribuida.servicios.ServicioOperaciones;

public class ClienteMain {

	@Configuration
	public static class ClienteConfig {
		
		@Bean
		public HttpInvokerProxyFactoryBean servivio( ) {
			
			HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean( );
			
			proxy.setServiceUrl( "http://localhost:8080/spring05-httpinvoker/app/http" );
			proxy.setServiceInterface( ServicioOperaciones.class );
			
			return proxy;
		}
	}
	
	public static void main(String[] args) {
		
		ApplicationContext context = 
			new AnnotationConfigApplicationContext( ClienteConfig.class ); 
		
		ServicioOperaciones servicio = 
			context.getBean( ServicioOperaciones.class );
		
		int respuesta = servicio.sumar( 2,  6 );
		
		System.out.printf( "La suma es: %d", respuesta );
	}
}
