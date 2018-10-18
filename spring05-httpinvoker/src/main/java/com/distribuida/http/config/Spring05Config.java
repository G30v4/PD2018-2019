package com.distribuida.http.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import com.distribuida.servicios.ServicioOperaciones;

@Configuration
@ComponentScan(basePackages="com.distribuida.servicios")
public class Spring05Config {

	@Bean(name="/http")
	public HttpInvokerServiceExporter http( ServicioOperaciones servicio ) {
		
		HttpInvokerServiceExporter ret = new HttpInvokerServiceExporter();
		
		ret.setService( servicio );
		ret.setServiceInterface( ServicioOperaciones.class );
		
		return ret;
	}
}
