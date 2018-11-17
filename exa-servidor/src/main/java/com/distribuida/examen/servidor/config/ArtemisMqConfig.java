package com.distribuida.examen.servidor.config;

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
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

@Configuration
@EnableJms
public class ArtemisMqConfig {

//	@Autowired
//	private BeanFactory springContextBeanFactory;

//	@Bean
//	ActiveMQQueue queueSinger() {
//		return new ActiveMQQueue("/queue/singer");
//	}

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
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		
		factory.setConnectionFactory(connectionFactory());
		//factory.setDestinationResolver(new BeanFactoryDestinationResolver(springContextBeanFactory));
		factory.setConcurrency("3-10");
		
		return factory;
	}
	
	//--------------------------------------------------------------------------------------------------
	//01. -- configuracion listener
//	@Bean
//	public DefaultMessageListenerContainer singerContainer( 
//		ConnectionFactory connectionFactory, 
//		@Qualifier("singerMqListener2") MessageListener listener ) {
//		
//		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer( );
//		container.setDestinationName( "/queue/singer" );
//		container.setConnectionFactory( connectionFactory );
//		container.setMessageListener( listener );
//		
//		return container;
//	}

	//--------------------------------------------------------------------------------------------------
	//02. -- configuracion adapter
//	@Bean
//	public DefaultMessageListenerContainer singerContainer( 
//		ConnectionFactory connectionFactory, 
//		MessageListenerAdapter singerAdapter ) {
//			
//		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer( );
//		container.setDestinationName( "/queue/singer" );
//		container.setConnectionFactory( connectionFactory );
//		container.setMessageListener( singerAdapter );
//		
//		return container;
//	}
//
//	@Bean
//	public MessageListenerAdapter singerAdapter( SingerMqAdapter singerAdapter ) {
//		
//		MessageListenerAdapter adapter = new MessageListenerAdapter( singerAdapter );
//		adapter.setDefaultListenerMethod( "receive" );
//		
//		return adapter;
//	}
}
