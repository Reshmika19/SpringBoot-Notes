package com.hexaware.springdatajpaexample.dto;

public class ProductDTO {
    private String name;
    private String description;
    private boolean active;
    
    public ProductDTO() {
		super();
    }
    
	public ProductDTO(String name, String description, boolean active) {
		super();
		this.name = name;
		this.description = description;
		this.active = active;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", description=" + description + ", active=" + active + "]";
	}
	
	
}
