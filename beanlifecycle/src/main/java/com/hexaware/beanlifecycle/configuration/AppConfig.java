package com.hexaware.beanlifecycle.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hexaware.beanlifecycle.entities.Address;
import com.hexaware.beanlifecycle.entities.Student;

@Configuration
public class AppConfig {

	@Bean
	public Address address() {
		return new Address();
	}
	
	/*
	 * @Bean(name = {"s1" , "s2"}) public Student student() { return new
	 * Student(address()); }
	 */
	
	@Bean(name = "studentBean" , initMethod = "init" , destroyMethod = "destroy")
	public Student student() {
		return new Student(address());
	}

	
	
}
