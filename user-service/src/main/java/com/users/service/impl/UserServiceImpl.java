package com.users.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.users.controller.UserController;
import com.users.dto.UserDto;
import com.users.exceptions.UserNotFoundException;
import com.users.passenger.repository.PassengerRepository;
import com.users.service.UserService;
import com.users.user.entity.User;
import com.users.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public User save(UserDto user) {
		
		User newUser = new User();
	    newUser.setUsername(user.getUsername());
	    newUser.setFirstName(user.getFirstName());
	    newUser.setLastName(user.getLastName());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setAge(user.getAge());
		newUser.setSalary(user.getSalary());
		return userRepository.save(newUser);
	}

public String authorizeUser(String userName,String password) {
	logger.info("authorizeUser method of userserviceImpl");
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Optional<User> userDetails=userRepository.findByUsername(userName);
		if(userDetails.isPresent()) {
			logger.info("db password::" + userDetails.get().getPassword());
			logger.info("encoded pwd::" + bcryptEncoder.encode(password));
				if (bcryptEncoder.matches(password, userDetails.get().getPassword())) {
					logger.info("passwords are matches");
					return "Successfully Authenticated";
				} else {
					logger.info("passwords are matches not matches");
					throw new UserNotFoundException("user name or password wrong");
				}
			}else {
				logger.info("details are not available");
				return "Invalid user name or password";
			}
		
	}






















}
