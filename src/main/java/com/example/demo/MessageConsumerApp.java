//package com.example.demo;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//
//import com.example.demo.model.Product;
//
//@SpringBootApplication(scanBasePackages = "com.example.demo")
//public class MessageConsumerApp {
//	
////	public static void main(String[]args) {
////		ApplicationContext context = SpringApplication.run(MessageConsumerApp.class, args);
////		MessageReceiver2 messagereceiver2 = (MessageReceiver2)context.getBean("messageReceiver2");
////		Product product = messagereceiver2.receiveMessage();
////		System.out.println("MessageReceived = "+product);
////	}
//	
//	public static void main(String[]args) {
//		ApplicationContext context = SpringApplication.run(MessageConsumerApp.class, args);
//		
//		try {
//			Thread.sleep(6000000);
//		}
//		catch(InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//}
