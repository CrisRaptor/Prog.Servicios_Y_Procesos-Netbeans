/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crisgc.exament4;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CrisGC
 */
public class Mail {
    private Properties properties;
    private Session session;

    public Mail() {
    }
    
    private void setProperties() {
        properties = System.getProperties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host", "mail.gmx.es");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", true);
        session = Session.getInstance(properties, null); //No recuerdo como inicializar Authenticator
    }
    
    public Transport setTransport(String email, String password){
        Transport transport = null;
        try {
            transport = (Transport) session.getTransport("smtp");
            transport.connect(properties.getProperty("mail.smtp.host"), email, password);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        
        return transport;

    }
    
    private Message createMessage(String sender, String reciever, String subject){
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(reciever));
            message.setSubject(subject);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        return message;
    }
    
    public void sendMessage(String sender, String receiver, String subject, String text, String email, String password, String filePath)  {
        try {
            setProperties();
            
            Message message = createMessage(sender, receiver, subject);
            Transport transport = setTransport(email, password);
            
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}
