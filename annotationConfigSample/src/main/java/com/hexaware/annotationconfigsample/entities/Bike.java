package com.hexaware.annotationconfigsample.entities;



import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("bike")
@Primary
public class Bike implements Vehicle{
	
	public void move() {
		System.out.println("Bike is Moving!");
	}
	
}
