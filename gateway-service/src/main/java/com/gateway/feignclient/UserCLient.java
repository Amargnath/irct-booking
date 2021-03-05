package com.gateway.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gateway.dto.UserDto;

import feign.Param;

@FeignClient(value = "user-client", url = "localhost:8089/irct/users")
public interface UserCLient {
	
	@GetMapping("/loaduserbyusername")
	public UserDto getUserByUserName(@Param("username") @RequestParam	String username);

	@GetMapping("/byName")
	public UserDto findByUsername(@Param("username") @RequestParam String username);

}
