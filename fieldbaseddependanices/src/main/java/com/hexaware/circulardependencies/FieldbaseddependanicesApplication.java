package com.hexaware.circulardependencies;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexaware.circulardependencies.configuration.AppConfig;
import com.hexaware.circulardependencies.entities.EmailService;
import com.hexaware.circulardependencies.entities.MessageSender;
import com.hexaware.circulardependencies.entities.SMSService;

@SpringBootApplication
public class FieldbaseddependanicesApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

		SMSService sms = appContext.getBean(SMSService.class);
		sms.sendMessage("Message");
		
		EmailService email = appContext.getBean(EmailService.class);
		email.sendMessage("Message");

		MessageSender sender = appContext.getBean(MessageSender.class);
		sender.sendMessage("Message");
		
		String[] beanNames = appContext.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanNames));
		
	}

}
