//package com.example.demo;

//import javax.jms.Connection;
//
//import javax.jms.ConnectionFactory;
//import javax.jms.Destination;
//import javax.jms.MessageProducer;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//
//import org.apache.activemq.ActiveMQConnection;
//import org.apache.activemq.ActiveMQConnectionFactory;
//public class MessageSender {
//	
//	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
//	private static String queueName = "MESSAGE_QUEUE";
//	
//    public static void main(String[] args) throws Exception {
//    	
//    
//        // Create a connection factory
//    	 ConnectionFactory factory = (ConnectionFactory) new ActiveMQConnectionFactory(url);
//
//        // Create a connection
//        Connection connection = factory.createConnection();
//        connection.start();
//
//        // Create a session
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//
//        // Create a destination (Queue or Topic)
//        Destination destination = session.createQueue(queueName);
//
//        // Create a producer
//        MessageProducer producer = session.createProducer(destination);
//
//        // Create a message
//        TextMessage message = session.createTextMessage("Hello ActiveMQ!");
//
//        // Send the message
//        producer.send(message);
//
//        System.out.println("Sent: " + message.getText());
//
//        // Clean up
//        session.close();
//        connection.close();
//    }
//}
