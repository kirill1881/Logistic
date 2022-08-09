package com.example.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailCongig {
    final Properties properties = new Properties();

    @Bean
    public MailSender mailSender(){

        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("krkr34080@gmail.com");
        mailSender.setPassword("scqaquppvxhgrzro");

        Properties props = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.debug", "true");

        return mailSender;
    }
}