package com.hexaware.springdatajpaexample.exceptions;

public class ResourceNotFoundException extends Exception{

	private String resourceName;
	private String fieldName;
	private String fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s is Not Found with %s : %s" , resourceName , fieldName , fieldValue ));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
}
