package com.hexaware.springdatajpasample.dto;

public class ProductDTO {

   // @NotNull(message = "Name cannot be null")
    private String name;

   // @NotNull(message = "Description cannot be null")
    private String description;

   // @NotNull(message = "Active status cannot be null")
    private boolean active;

    // Constructor
    public ProductDTO(String name, String description, Boolean active) {
        this.name = name;
        this.description = description;
        this.active = active;
    }

    // Default constructor
    public ProductDTO() {}

    // Getters and setters
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ProductDTO [name=" + name + ", description=" + description + ", active=" + active + "]";
    }

	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}
}
