package com.hexaware.sterotypeannotations.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository {
	public String greetUser() {
		return "Hello User! from Repository";
	}
}
