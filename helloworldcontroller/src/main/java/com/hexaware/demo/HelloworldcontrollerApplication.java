package com.hexaware.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hexaware.demo.configuration.AppConfig;
import com.hexaware.demo.entities.Bike;
import com.hexaware.demo.entities.Car;
import com.hexaware.demo.entities.Cycle;

@SpringBootApplication
public class HelloworldcontrollerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldcontrollerApplication.class, args);
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		Car car = applicationContext.getBean(Car.class);
		car.move();
		Bike bike = applicationContext.getBean(Bike.class);
		bike.move();
		Cycle cycle = applicationContext.getBean(Cycle.class);
		cycle.move();
	}

}
