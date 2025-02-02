
package com.crisgc.mailwindow;

import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author CrisGC
 */
public class MailService {

    private Properties properties;
    private Session session;
    
    private void setSMTPServerProperties() {
        properties = System.getProperties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host", "mail.gmx.es");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", true);
        session = Session.getInstance(properties, null);
    }
    
    private Transport connectMailServer(String email, String password) throws NoSuchProviderException, MessagingException {
        Transport transport = (Transport) session.getTransport("smtp");
        transport.connect(properties.getProperty("mail.smtp.host"), email, password);
        
        return transport;
    }
    
    private Message createMessage(String sender, String reciever, String subject) throws AddressException, MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sender));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(reciever));
        message.setSubject(subject);
        
        return message;
    }
    
    private Message createMultipartMessage(String sender, String receiver, String subject, String text, String filePath) throws MessagingException, IOException {
        Message message = createMessage(sender, receiver, subject);
        
        // Cuerpo del mensaje
        BodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(text);
        
        // Adjunto de mensaje
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.attachFile(new File(filePath));
        
        // Composición del mensaje (Cuerpo + adjunto)
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(bodyPart);
        multipart.addBodyPart(mimeBodyPart);
        message.setContent(multipart);        
        
        return message;
    }
    
    public void sendMultipartMessage(String sender, String receiver, String subject, String text, String email, String password, String filePath) throws MessagingException, IOException {
        setSMTPServerProperties();
        
        Message message = createMultipartMessage(sender, receiver, subject, text, filePath);
        Transport transport = connectMailServer(email, password);
        
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
