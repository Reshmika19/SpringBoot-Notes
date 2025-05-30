package com.hexaware.annotationtask;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexaware.annotationtask.entities.MessageSender;
import com.hexaware.annotationtask.entities.MessageService;

@SpringBootApplication
public class AnnotationtaskApplication {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(com.hexaware.annotationtask.config.AppConfig.class);

		MessageService sms = ac.getBean( MessageService.class);
        sms.sendMessage("Hello message from SMS Service");
        
		MessageService email = (MessageService) ac.getBean("emailService");
		email.sendMessage("Hello message from Email Service");
        
        MessageSender sender = ac.getBean(MessageSender.class);
        sender.sendMessage("Hello message from MessageSender");
        
		
	}
	
}
