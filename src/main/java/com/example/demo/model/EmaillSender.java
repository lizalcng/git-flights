package com.example.demo.model;


import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Component;

import javax.mail.*;


@Component
public class EmaillSender {
    public void sendMail(String email, String confirmation ) throws IOException {
        // Recipient's email ID needs to be mentioned.
        String to = email;

        // Sender's email ID and credentials.
        String from = "lizalcngg@gmail.com";
        final String username = "lizalcngg@gmail.com"; // replace with your actual username
        final String password = "ennd kugp qunw cvdi"; // replace with your actual password

        // Set up mail server properties.
        String host = "smtp.gmail.com"; // your SMTP server, e.g., smtp.gmail.com for Gmail

        // Get system properties.
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // TLS
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587"); // TLS port

        // Get the Session object.
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field.
            message.setFrom(new InternetAddress(from));

            // Set To: header field.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject: header field.
            message.setSubject("You booked your flights");

            // Set the actual message.
            message.setText("Your confirmation number is "+confirmation);
            
//            Multipart emailContent = new MimeMultipart();
//            
//            MimeBodyPart textBodyPart = new MimeBodyPart();
//            textBodyPart.setText("My multipart text");
//            
//            MimeBodyPart pdfAttachment = new MimeBodyPart();
//            pdfAttachment.attachFile("/Users/lizalsingh/Desktop/Screenshot 2024-05-16 at 2.26.15 PM.png");
//            
//            emailContent.addBodyPart(textBodyPart);
//            emailContent.addBodyPart(pdfAttachment);
//            
//            message.setContent(emailContent);            

            // Send message.
            Transport.send(message);

            System.out.println("Sent message successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

