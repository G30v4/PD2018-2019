package com.distribuida.examen.servidor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

import com.distribuida.examen.servidor.servicios.ServicioDirecciones;
import com.distribuida.examen.servidor.servicios.ServicioPersonas;

@Configuration
@ComponentScan( basePackages= {"com.distribuida.examen.servidor.servicios", "com.distribuida.examen.servidor.mq"})
@Import(ArtemisMqConfig.class)
public class ExamenServerConfig {

	@Bean(name="/personas")
	public HttpInvokerServiceExporter httpPersonas( ServicioPersonas servicio ) {

		HttpInvokerServiceExporter ret = new HttpInvokerServiceExporter();
		
		ret.setService( servicio );
		ret.setServiceInterface( ServicioPersonas.class );
		
		return ret;
	}
	
	@Bean(name="/direcciones")
	public HttpInvokerServiceExporter httpDirecciones( ServicioDirecciones servicio ) {

		HttpInvokerServiceExporter ret = new HttpInvokerServiceExporter();
		
		ret.setService( servicio );
		ret.setServiceInterface( ServicioDirecciones.class );
		
		return ret;
	}
}
