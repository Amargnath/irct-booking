package com.users.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.users.dto.TravelHistoryRequest;
import com.users.dto.TravellHistoryResponse;
import com.users.dto.UserDto;
import com.users.service.UserService;
import com.users.user.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public User signup(@RequestBody UserDto user) {
		logger.info("into signup method of userservice");
		return userService.save(user);
	}

	@GetMapping("/authenticate")
	public String authenticateUser(@RequestParam String userName, @RequestParam String password) {
		logger.info("into authenticateUser method of userservice");
		return userService.authorizeUser(userName, password);

	}
	
	@GetMapping("/travelHistory")
	public TravellHistoryResponse getTravellHistory(@RequestBody TravelHistoryRequest request) {
		
		//can implements circuit brekers from USerServiceImpls by passing user id to TicketBooking-Service
		//and if TicketBooking-Service down we can send default error message saying booking sevice is down
		return null;
	}

}
