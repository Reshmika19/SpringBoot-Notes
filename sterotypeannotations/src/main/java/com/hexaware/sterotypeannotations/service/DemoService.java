package com.hexaware.sterotypeannotations.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
	public String greetUser() {
		return "Hello User! from Service";
	}
}
