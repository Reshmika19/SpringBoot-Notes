package com.hexaware.firstspringboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.firstspringboot.authentities.UserData;
import com.hexaware.firstspringboot.service.IUserService;
import com.hexaware.firstspringboot.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	private UserServiceImpl userService;
	
	@Autowired
	public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	@GetMapping("/findByUserName")
	public ResponseEntity<Optional<UserData>> findByUserName(@RequestParam("username") String userName){
		Optional<UserData> user = userService.findByUserName(userName);
		return ResponseEntity.ok(user);
	}
}

