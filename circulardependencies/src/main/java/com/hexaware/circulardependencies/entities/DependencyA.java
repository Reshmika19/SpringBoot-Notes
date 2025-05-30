package com.hexaware.circulardependencies.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dependencyA")
public class DependencyA {
	
	
	private DependencyB dependencyB;
	//circular dependanices can be avoided using setter di
	
//	public DependencyA(DependencyB dependencyB) {
//		this.dependencyB = dependencyB;
//	}

	@Autowired
	public void setDependencyB(DependencyB dependencyB) {
	    this.dependencyB = dependencyB;
	}

	
	
}
