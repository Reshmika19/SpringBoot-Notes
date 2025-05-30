package com.hexaware.firstspringboot.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hexaware.firstspringboot.authentities.UserData;

@Service
public interface IUserService {
	 Optional<UserData> findByUserName(String userName);
	 boolean existsByEmail(String email);
	 Optional<UserData> findByUserNameOrEmail(String userName, String email);
}
