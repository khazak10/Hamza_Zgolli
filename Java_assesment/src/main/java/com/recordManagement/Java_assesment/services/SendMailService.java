package com.recordManagement.Java_assesment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.recordManagement.Java_assesment.model.EmailEntity;
import com.recordManagement.Java_assesment.repositorys.EmailRepo;
import com.recordManagement.Java_assesment.servicesImpl.SendMailServiceImpl;

@Service
public class SendMailService implements SendMailServiceImpl {
	@Autowired
	private EmailRepo emailRepo;
	@Autowired
	private JavaMailSender javaMailSender;
	private String MyEmail = "hamzazgolli@gmail.com";

	public SendMailService(EmailRepo emailRepo) {
		this.emailRepo = emailRepo;
	}

	@SuppressWarnings("finally")
	public EmailEntity SendMai(EmailEntity email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(MyEmail);
		message.setSubject(email.getSubject());
		message.setText(email.getMessage());
		try {
			javaMailSender.send(message);
		} catch (Exception e) {
			email.setSent(false);
		} finally {
			return emailRepo.save(email);
		}
	}
}
