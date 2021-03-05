package com.users.service;

import com.users.dto.UserDto;
import com.users.user.entity.User;

public interface UserService {

	User save(UserDto user);

	String authorizeUser(String userName, String password);

}
