package com.hexaware.xmlconfigsample.entities;

public class Cycle implements Vehicle{
	@Override
	public void move() {
		System.out.println("Cycle is Moving!");
	}
}
