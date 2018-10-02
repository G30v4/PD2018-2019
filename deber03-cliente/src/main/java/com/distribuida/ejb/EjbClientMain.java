package com.distribuida.ejb;

import javax.naming.InitialContext;

import com.distribuida.ejb.servicios.ServicioOperaciones;

public class EjbClientMain {

	//public static final String SERVICE_NAME = "java:global/deber03/ServicioOperacionesImpl";
	//public static final String SERVICE_NAME = "java:global/deber03/ServicioOperacionesImpl!com.distribuida.ejb.servicios.ServicioOperaciones";
	//public static final String SERVICE_NAME = "ServicioOperacionesImplRemote";
	public static final String SERVICE_NAME = "servicioOperaciones";
	
	public static void main(String[] args) throws Exception {

		//Properties p = new Properties();
		//
		//p.put( InitialContext.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.RemoteInitialContextFactory");		
		//p.put( InitialContext.PROVIDER_URL, "ejbd://127.0.0.1:4201" );
		//
		//InitialContext ctx = new InitialContext(p);
		
		InitialContext ctx = new InitialContext( );
		
		ServicioOperaciones servicio = (ServicioOperaciones )ctx.lookup( SERVICE_NAME );
		
		int resultado = servicio.sumar( 1, 2 );

		System.out.println( "resultado: " + resultado );

	}

}
