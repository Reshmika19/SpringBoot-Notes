package com.hexaware.annotationtask.entities;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {


	private MessageService messageService;

	
	public MessageSender(@Qualifier("smsService") MessageService messageService) {
		this.messageService = messageService;
	}
	
	
	public void sendMessage(String message) {
		messageService.sendMessage(message);
	}
}
