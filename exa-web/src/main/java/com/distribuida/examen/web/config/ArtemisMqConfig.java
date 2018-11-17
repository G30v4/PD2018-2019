package com.distribuida.examen.web.config;

import java.util.HashMap;
import java.util.Map;

import javax.jms.ConnectionFactory;

import org.apache.activemq.artemis.api.core.TransportConfiguration;
import org.apache.activemq.artemis.api.jms.ActiveMQJMSClient;
import org.apache.activemq.artemis.api.jms.JMSFactoryType;
import org.apache.activemq.artemis.core.remoting.impl.netty.NettyConnectorFactory;
import org.apache.activemq.artemis.core.remoting.impl.netty.TransportConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

/**
 * 
 * @author jsalvador
 *
 */
@Configuration
public class ArtemisMqConfig {

	@Bean
	public ConnectionFactory connectionFactory() {
		Map<String, Object> connDetails = new HashMap<>();
		
		connDetails.put(TransportConstants.HOST_PROP_NAME, "0.0.0.0");
		connDetails.put(TransportConstants.PORT_PROP_NAME, "61616");
		connDetails.put(TransportConstants.PROTOCOLS_PROP_NAME, "tcp");
		
		TransportConfiguration transportConfiguration = new TransportConfiguration(
				NettyConnectorFactory.class.getName(), connDetails);
		
		return ActiveMQJMSClient.createConnectionFactoryWithoutHA(JMSFactoryType.CF,transportConfiguration);
	}
	
	@Bean
	public JmsTemplate jmsTemplate( ) {
		return new JmsTemplate( connectionFactory( ) );
	}
}
