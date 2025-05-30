package com.hexaware.constructordi;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexaware.constructordi.configuration.AppConfig;
import com.hexaware.constructordi.entities.EmailService;
import com.hexaware.constructordi.entities.MessageSender;
import com.hexaware.constructordi.entities.SMSService;

@SpringBootApplication
public class ConstructordiApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		SMSService sms = appContext.getBean(SMSService.class);
		sms.sendMessage("Message");
		
		EmailService email = appContext.getBean(EmailService.class);
		email.sendMessage("Message");

		MessageSender sender = appContext.getBean(MessageSender.class);
		sender.sendMessage("Message");
	}

}
