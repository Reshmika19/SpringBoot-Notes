package com.hexaware.demo.entities;

public class Traveller {
	Vehicle vehicleObj = null;
	Traveller(Vehicle obj){
		this.vehicleObj = obj;
	}
	public void startJourney() {
		this.vehicleObj.move();
	}

}
