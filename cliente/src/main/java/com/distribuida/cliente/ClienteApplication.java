package com.distribuida.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ClienteApplication {

	@Autowired private DiscoveryClient registro;
	
	@Bean @LoadBalanced
	public RestTemplate restTempalte( ) {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}
	
	@Autowired private RestTemplate template;
	
	@GetMapping(path="/cliente")
	public String cliente( ) {
		
		RestTemplate template1 = new RestTemplate();
		
		List<ServiceInstance> s01 = registro.getInstances( "servidor01" );
		
		StringBuilder sb = new StringBuilder();
		
		for( ServiceInstance s:s01 ) {
			sb.append( s.getUri() );
			sb.append( System.lineSeparator( ) );
		}
		
		System.out.println( sb.toString( ) );
		
		int index = ((int)(Math.random() * 10)) % s01.size();
		
		//String url = String.format( "%s/test", s01.get(0).getUri() );
		String url = s01.get(index).getUri() + "/test";
		
		return template1.getForObject( url, String.class );
	}
	
	@GetMapping(path="/cliente2")
	public String cliente2( ) {
		
		return template.getForObject( "http://servidor01/test", String.class );
	}

}


