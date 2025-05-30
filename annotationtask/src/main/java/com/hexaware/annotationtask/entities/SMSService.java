package com.hexaware.annotationtask.entities;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("smsService")
@Primary
public class SMSService implements MessageService{
	public void sendMessage(String message) {
		 System.out.println("SMS: " + message);
	}
}
