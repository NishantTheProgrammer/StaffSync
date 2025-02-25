package com.programmer.StaffSync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
        private final String senderEmail = "hello@nishanttheprogrammer.com";

        @Autowired
        private JavaMailSender javaMailSender;
    
        public void send(String[] emails, String subject, String html) throws MessagingException {
                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper mail = new MimeMessageHelper(mimeMessage, "utf-8");

                mail.setTo(emails);
                mail.setFrom(senderEmail);
                mail.setSubject(subject);
                mail.setText(html, true);

                javaMailSender.send(mimeMessage);
        }    
    }