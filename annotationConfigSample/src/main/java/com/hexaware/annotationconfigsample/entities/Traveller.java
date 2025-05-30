package com.hexaware.annotationconfigsample.entities;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("traveller")
public class Traveller {
	Vehicle vehicleObj = null;
	
	Traveller(@Qualifier("car")Vehicle obj){
		this.vehicleObj = obj;
	}
	
	public void startJourney() {
		this.vehicleObj.move();
	}

}
