package com.hexaware.annotationconfigsample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexaware.annotationconfigsample.configuration.AppConfig;
import com.hexaware.annotationconfigsample.entities.Bike;
import com.hexaware.annotationconfigsample.entities.Car;
import com.hexaware.annotationconfigsample.entities.Cycle;
import com.hexaware.annotationconfigsample.entities.Traveller;

@SpringBootApplication
public class AnnotationconfigsampleApplication {

	public static void main(String[] args) {
		//SpringApplication.run(AnnotationconfigsampleApplication.class, args);
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Car car = applicationContext.getBean(Car.class);
		car.move();
		Bike bike = applicationContext.getBean(Bike.class);
		bike.move();
		Cycle cycle = applicationContext.getBean(Cycle.class);
		cycle.move();
		Traveller traveller = applicationContext.getBean(Traveller.class);
		traveller.startJourney();
	}

}
