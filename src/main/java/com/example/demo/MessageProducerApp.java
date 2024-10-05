//package com.example.demo;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//
//import com.example.demo.model.Product;
//
//@SpringBootApplication(scanBasePackages = "com.example.demo")
//public class MessageProducerApp {
//
//    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(MessageProducerApp.class, args);
//        MessageSender2 messageSender2 = context.getBean(MessageSender2.class);
//        Product product = new Product();
//        product.setProductId(1);
//        product.setName("Laptop");
//        product.setQuantity(10);
//        messageSender2.sendMessage(product);
//        System.out.println("Message has been sent successfully");
//    }
//
//}
//
//
////package com.example.demo;
////
////import org.springframework.boot.autoconfigure.SpringBootApplication;
////import org.springframework.context.annotation.AnnotationConfigApplicationContext;
////import org.springframework.context.support.AbstractApplicationContext;
////
////import com.example.demo.config.AppConfig;
////
////@SpringBootApplication(scanBasePackages = "com.example.demo")
////public class MessageProducerApp {
////	
////	public static void main(String[]args) {
////		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
////		MessageSender2 messageSender2 = context.getBean(MessageSender2.class);
////		messageSender2.sendMessage("Hi ActiveMQ");
////		System.out.println("Message has been sent successfully");
////		
////		((AbstractApplicationContext)context).close();
////	}
////
////}
