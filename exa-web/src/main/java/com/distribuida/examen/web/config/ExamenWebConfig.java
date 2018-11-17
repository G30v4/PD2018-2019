package com.distribuida.examen.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

import com.distribuida.examen.servidor.servicios.ServicioDirecciones;
import com.distribuida.examen.servidor.servicios.ServicioPersonas;

/**
 * 
 * @author jsalvador
 *
 */
@Configuration
@ComponentScan( basePackages="com.distribuida.examen.web")
@Import(ArtemisMqConfig.class)
public class ExamenWebConfig {

	@Bean
	@Lazy
	public HttpInvokerProxyFactoryBean servivioPersonas( ) {
		
		HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean( );
		
		proxy.setServiceUrl( "http://localhost:9080/exa-servidor/app/personas" );
		proxy.setServiceInterface( ServicioPersonas.class );
		
		return proxy;
	}
	
	@Bean
	@Lazy
	public HttpInvokerProxyFactoryBean servivioDirecciones( ) {
		
		HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean( );
		
		proxy.setServiceUrl( "http://localhost:9080/exa-servidor/app/direcciones" );
		proxy.setServiceInterface( ServicioDirecciones.class );
		
		return proxy;
	}
}
