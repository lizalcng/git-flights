//package com.example.demo.config;
//
//import java.util.Arrays;
//
//
//import javax.jms.ConnectionFactory;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.listener.DefaultMessageListenerContainer;
//import org.springframework.jms.listener.MessageListenerContainer;
//import org.springframework.jms.support.converter.MessageConverter;
//import org.springframework.jms.support.converter.SimpleMessageConverter;
//
//import com.example.demo.MessageReceiver2;
//
//@Configuration
//public class MessagingConfiguration {
//	
//	private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
//	private static final String MESSAGE_QUEUE = "message_queue";
//	
//	@Autowired
//	MessageReceiver2 messageReceiver2;
//	
//	   @Bean
//	    public ConnectionFactory connectionFactory() {
//	        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
//	        factory.setBrokerURL(DEFAULT_BROKER_URL);
//	        factory.setTrustedPackages(Arrays.asList("com.example.demo.model", "java.util", "java.lang"));
////	        factory.setTrustedPackages(Arrays.asList("com.ram"));
//	        return factory;
//	    }
//	   
//	   @Bean
//	   public MessageListenerContainer getContainer(){
//		   DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
//		   container.setConnectionFactory(connectionFactory());
//		   container.setDestinationName(MESSAGE_QUEUE);
//		   container.setMessageListener(messageReceiver2);
//		   return container;
//	   }
//	   
//	   @Bean
//	   public JmsTemplate jmsTemplate() {
//		   JmsTemplate template = new JmsTemplate();
//		   template.setConnectionFactory(connectionFactory());
//		   template.setDefaultDestinationName(MESSAGE_QUEUE);
//		   return template;
//		   
//	   }
//	   
//
//	   
////	   @Bean
////	   public MessageSender2 messageSender() {
////		   return new MessageSender2();
////	   }
//	   
//	
//	
//
//}
