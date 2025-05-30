package com.hexaware.circulardependencies.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

	@Autowired
	@Qualifier("email")
	private MessageService emailService;
	
	@Autowired
	@Qualifier("sms")
	private MessageService smsService ; 

	/*
	 * //@Autowired public void setSmsService(@Qualifier("sms")MessageService
	 * smsService) { this.smsService= smsService; //setter based dependency
	 * injection.
	 * 
	 * }
	 * 
	 * //@Autowired MessageSender(@Qualifier("email") MessageService emailService){
	 * this.emailService = emailService; }
	 * 
	 * //@Autowired public MessageSender(@Qualifier("email")MessageService
	 * emailService,@Qualifier("sms") MessageService smsService) { super();
	 * this.emailService = emailService; //constructor based DI. this.smsService =
	 * smsService; }
	 */
	
	public void sendMessage(String message){
        this.emailService.sendMessage(message);
        this.smsService.sendMessage(message);
       }

}
