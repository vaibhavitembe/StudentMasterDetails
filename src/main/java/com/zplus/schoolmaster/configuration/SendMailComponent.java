package com.zplus.schoolmaster.configuration;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class SendMailComponent {
    @Autowired
    private JavaMailSender sender;
    public String sendMail(String toEmailId,String content,String subject) throws MessagingException {


        final String userName = "zpluscybersecuretech@gmail.com";
        final String password ="Zplus#123!@";
        String fromEmail ="zpluscybersecuretech@gmail.com";
        String toEmail = toEmailId;

        Properties properties = new Properties();

        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        Session session = Session.getInstance(properties,new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        MimeMessage msg = new MimeMessage(session);
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(msg,true);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        try
        {
            helper.setFrom(new InternetAddress(fromEmail));
            // helper.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(content,true);

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        sender.send(msg);
        return "Mail Sent Success!";
    }
}
