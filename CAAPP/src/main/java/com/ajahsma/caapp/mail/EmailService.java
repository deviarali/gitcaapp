package com.ajahsma.caapp.mail;

public interface EmailService {

	public String sendEmail(String[] tos, String subject, String body) throws Exception;
	
}
