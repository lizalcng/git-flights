//package com.example.demo;
//
//import javax.jms.JMSException;
//
//import javax.jms.Message;
//import javax.jms.Session;
//
//import javax.jms.ObjectMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.core.MessageCreator;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.model.Product;
//
//
//@Component
//public class MessageSender2 {
//	
//	@Autowired
//	JmsTemplate jmsTemplate;
//	
//	public void sendMessage(final Product product) {
//		jmsTemplate.send(new MessageCreator() {
//			public Message createMessage(Session session)throws JMSException{
//				ObjectMessage objectMessage =  session.createObjectMessage(product);
//				return objectMessage;
//			}
//			
//		});
//	}
//
//}
