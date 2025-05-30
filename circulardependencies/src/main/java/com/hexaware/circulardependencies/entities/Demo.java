package com.hexaware.circulardependencies.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	//immutability is possible only for constructor di. not supporeted by setter di
    private final DependencyA dependencyA;
    private final DependencyB dependencyB;
    private final DependencyC dependencyC;

    @Autowired
    public Demo(DependencyA dependencyA, DependencyB dependencyB, DependencyC dependencyC) {
        this.dependencyA = dependencyA;
        this.dependencyB = dependencyB;
        this.dependencyC = dependencyC;
    }
    
    
}
