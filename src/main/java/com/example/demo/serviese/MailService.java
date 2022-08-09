package com.example.demo.serviese;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class MailService {
    final Properties properties = new Properties();

    @Bean
    public JavaMailSender mailSender(){

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("krkr34080@gmail.com");
        mailSender.setPassword("scqaquppvxhgrzro");

        Properties properties = new Properties();

        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.debug", "true");

        mailSender.setJavaMailProperties(properties);

        return mailSender;
    }
}
