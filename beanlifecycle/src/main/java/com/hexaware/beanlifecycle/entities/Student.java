package com.hexaware.beanlifecycle.entities;

public class Student {
	Address address;

	public Student(Address address) {
		super();
		this.address = address;
	}
	
	public void display() {
		System.out.println("Student Class method called...");

	}
	
	public void init() {
		System.out.println("Initialization logic....");
	}
	
	public void destroy() {
		System.out.println("Destruction logic....");
	}

}
