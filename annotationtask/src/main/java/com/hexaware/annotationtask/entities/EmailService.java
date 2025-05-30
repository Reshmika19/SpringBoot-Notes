package com.hexaware.annotationtask.entities;

import org.springframework.stereotype.Component;

@Component("emailService")
public class EmailService implements MessageService{
	public void sendMessage(String message) {
		 System.out.println("Email: " + message);
	}
}
