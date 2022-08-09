package com.example.demo.components;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayOutputStream;


import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.InputStream;

@Component
public class SendMail {
    @Autowired
    JavaMailSender mailSender;

    public void sendMail(long id, MultipartFile file){
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper msg = null;
        try {
            msg = new MimeMessageHelper(message, true);
            msg.setTo("krkr34080@gmail.com");
            msg.setFrom("krkr34080@gmail.com");
            msg.setSubject(String.valueOf(id));
            msg.setText("321123");
            InputStream inputStream = file.getInputStream();

            msg.addAttachment(file.getOriginalFilename(), file);

            /*   msg.addAttachment("file", file);*/

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
