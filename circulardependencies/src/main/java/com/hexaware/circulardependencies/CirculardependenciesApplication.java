package com.hexaware.circulardependencies;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexaware.circulardependencies.configuration.AppConfig;
import com.hexaware.circulardependencies.entities.DependencyA;

@SpringBootApplication
public class CirculardependenciesApplication {

	public static void main(String[] args) {
		//SpringApplication.run(CirculardependenciesApplication.class, args);
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		DependencyA dependencyA = applicationContext.getBean(DependencyA.class);
		System.out.println(dependencyA);
		
	}

}
