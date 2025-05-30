package com.hexaware.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hexaware.demo.entities.Bike;
import com.hexaware.demo.entities.Car;
import com.hexaware.demo.entities.Cycle;
import com.hexaware.demo.entities.Vehicle;

@Configuration
public class AppConfig {
	
	@Bean
	public Vehicle car(){
		return new Car();
	}
	
	@Bean
	public Vehicle bike(){
		return new Bike();
	}

	@Bean
	public Vehicle cycle(){
		return new Cycle();
	}
}
