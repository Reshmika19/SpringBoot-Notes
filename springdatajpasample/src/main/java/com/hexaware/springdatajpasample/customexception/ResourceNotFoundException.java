package com.hexaware.springdatajpasample.customexception;

public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldValue;
    private String fieldName;

    public ResourceNotFoundException(String resourceName, String fieldValue, String fieldName) {
        super(String.format("%s is not found with %s: %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldValue = fieldValue;
        this.fieldName = fieldName;
    }
}
