package com.hexaware.sterotypeannotations;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexaware.sterotypeannotations.configuration.AppConfig;
import com.hexaware.sterotypeannotations.controller.DemoController;
import com.hexaware.sterotypeannotations.repository.DemoRepository;
import com.hexaware.sterotypeannotations.service.DemoService;

@SpringBootApplication
public class SterotypeannotationsApplication {

	public static void main(String[] args) {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		DemoController demoController =  ac.getBean(DemoController.class);
		System.out.println(demoController.greetUser());
		
		DemoRepository demoRepo = ac.getBean(DemoRepository.class);
		System.out.println(demoRepo.greetUser());
		
		DemoService demoService = ac.getBean(DemoService.class);
		System.out.println(demoService.greetUser());
		
	}

}
