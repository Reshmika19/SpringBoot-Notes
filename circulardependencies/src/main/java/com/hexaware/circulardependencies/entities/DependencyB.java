package com.hexaware.circulardependencies.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dependencyB")
public class DependencyB {
	private DependencyA dependencyA;
	
//	public DependencyB(DependencyA dependencyA) {
//		//this.dependencyA = dependencyA;
//	}
	
	@Autowired
	public void setDependencyA(DependencyA dependencyA) {
	    this.dependencyA = dependencyA;
	}

}
