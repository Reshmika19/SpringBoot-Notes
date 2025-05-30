package com.hexaware.xmlconfigsample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hexaware.xmlconfigsample.entities.Bike;
import com.hexaware.xmlconfigsample.entities.Car;
import com.hexaware.xmlconfigsample.entities.Traveller;

@SpringBootApplication
public class XmlconfigsampleApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Car obj = (Car) ac.getBean("car");
		obj.move();
		Bike bikeObj = ac.getBean(Bike.class);
		bikeObj.move();
		Traveller tObj = ac.getBean(Traveller.class);
		tObj.startJourney();
	}

}
