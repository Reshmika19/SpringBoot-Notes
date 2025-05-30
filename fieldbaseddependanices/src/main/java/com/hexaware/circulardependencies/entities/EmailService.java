package com.hexaware.circulardependencies.entities;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailService implements MessageService {

	public void sendMessage(String message) {

		System.out.println(message + " from Email");

	}
}