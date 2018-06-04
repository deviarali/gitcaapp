package com.ajahsma.caapp.mail;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender sender;

	@Override
	public String sendEmail(String[] tos, String subject, String body) throws Exception {
		MimeMessage message = sender.createMimeMessage();
		message.setContent(body, "text/html; charset=utf-8");
		message.setSentDate(new Date());
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setTo(tos);
		helper.setSubject(subject);
//		helper.setText(body);

		sender.send(message);

		return "Email Sent!";
	}

	private String sendEmail() throws Exception {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setTo("sharanu.ainapur@gmail.com");
		helper.setText("How are you?");
		helper.setSubject("Hi");

		sender.send(message);

		return "Email Sent!";
	}
}
