package com.sendemail.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.sendemail.dto.EmailDto;

@Service
public class EmailService {

	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	TemplateEngine engine;
	
	@Value("${mail.urlFront}")
	private String urlFront;
	
	public void sendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("usuario@gmail.com");
		message.setTo("usuario@gmail.com");
		message.setSubject("Correo simple de prueba");
		message.setText("Este es el contenido del correo");
		
		javaMailSender.send(message);
	}
	
	public void sendEmailTemplate(EmailDto dto) {
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			Context context = new Context();
			Map<String, Object> map = new HashMap<>();
			map.put("userName", dto.getUserName());
			map.put("url", urlFront + dto.getJwt());
			context.setVariables(map);
			String htmlText = engine.process("email-template", context);
			helper.setFrom(dto.getMailFrom());
			helper.setTo(dto.getMailTo());
			helper.setSubject(dto.getSubject());
			helper.setText(htmlText,true);
			
			javaMailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
