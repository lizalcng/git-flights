//package com.example.demo;
//
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.support.converter.MessageConverter;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.demo.model.Product;
//
//
//	
//@Component
////public class MessageReceiver2 {
//	public class MessageReceiver2 implements MessageListener {
//
////@Autowired
////private JmsTemplate jmsTemplate;
//	
//@Autowired
//MessageConverter messageConverter;
//
//
//
//public void onMessage(Message message) {
//	try {
//		Product product = (Product) messageConverter.fromMessage(message);
//		System.out.println("Inside onMessage ");
//		System.out.println(product);
//		System.out.println("Inside onMessage ");
//	}
//	catch(JMSException e) {
//		e.printStackTrace();
//	}
//}
//
//
//		
////		public Product receiveMessage() {
////			try {
////				Message message = jmsTemplate.receive();
////				Product product = (Product) messageConverter.fromMessage(message);
////				return product;
////			}
////			catch(Exception e) {
////				e.printStackTrace();
////			}
////			return null;
////			
////		}
//		
//	}
//
