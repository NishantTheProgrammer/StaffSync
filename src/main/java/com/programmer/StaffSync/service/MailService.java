package com.programmer.StaffSync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.Map;

@Service
public class MailService {
    private final String senderEmail = "hello@nishanttheprogrammer.com";

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine; // Inject Thymeleaf engine

    /**
     * Sends a plain text or HTML email (without templates)
     */
    public void send(String[] emails, String subject, String content) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mail = new MimeMessageHelper(mimeMessage, "utf-8");

        mail.setTo(emails);
        mail.setFrom(senderEmail);
        mail.setSubject(subject);
        mail.setText(content, true); // Supports both plain text and HTML

        javaMailSender.send(mimeMessage);
    }

    /**
     * Sends an email using a Thymeleaf template
     */
    public void sendTemplateEmail(String[] emails, String subject, String templateName, Map<String, Object> variables) throws MessagingException {
        Context context = new Context();
        context.setVariables(variables);

        String htmlContent = templateEngine.process(templateName, context);

        send(emails, subject, htmlContent);
    }
}