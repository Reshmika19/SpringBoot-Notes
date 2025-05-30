package com.hexaware.circulardependencies.entities;

import org.springframework.stereotype.Component;

@Component("sms")
public class SMSService implements MessageService {

	public void sendMessage(String message) {

		System.out.println(message + " from SMS");

	}
}