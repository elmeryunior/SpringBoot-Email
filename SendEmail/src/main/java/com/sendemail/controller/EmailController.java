package com.sendemail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sendemail.dto.EmailDto;
import com.sendemail.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@GetMapping("email/send")
	public ResponseEntity<?> sendEmail(){
		emailService.sendEmail();
		return new ResponseEntity("Correo enviado con exito",HttpStatus.OK);
	}
	
	@PostMapping("email/send-html")
	public ResponseEntity<?> sendEmailTemplate(@RequestBody EmailDto dto){
		emailService.sendEmailTemplate(dto);
		return new ResponseEntity("Correo con plantilla enviado con exito",HttpStatus.OK);
	}
}
