package com.gateway.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gateway.dto.UserDto;
import com.gateway.feignclient.UserCLient;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserCLient userCLient;

	public UserDto save(UserDto user) {
		// TODO Auto-generated method stub
		
		String url="http://localhost:8089/irct/users";
		
		UserDto response=restTemplate.postForObject(url, user, UserDto.class);
		
		return null;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username =====>> "+username);
		UserDto user = userCLient.getUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthority());
	}
	
	public UserDto findOne(String username) {
		return userCLient.findByUsername(username);
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	

}
