package com.hexaware.sterotypeannotations.controller;

import org.springframework.stereotype.Controller;

@Controller
public class DemoController {
	public String greetUser() {
		return "Hello User! from Controller";
	}
}
