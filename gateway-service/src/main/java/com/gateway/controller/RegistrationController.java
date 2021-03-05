package com.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.dto.UserDto;
import com.gateway.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired 
	  private UserServiceImpl userService;
	 

	@PostMapping("/signup")
	public UserDto signup(@RequestBody UserDto user) {
		logger.info("Register started");
		return userService.save(user);
	}

}
