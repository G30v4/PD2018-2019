package com.distribuida.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.distribuida.servicios.ServicioOperaciones;
import com.distribuida.servicios.ServicioOperacionesImpl;

@Configuration
@ComponentScan(basePackages="com.distribuida.servicios")
public class Spring01Config {

	@Bean
	public ServicioOperaciones servicioOp( ) {
		return new ServicioOperacionesImpl( );
	}
}
