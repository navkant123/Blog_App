package com.codewithnavkant.blog.services;

import java.util.List;

import com.codewithnavkant.blog.payloads.UserDto;

public interface UserService {
	// method for create user
	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto userDto, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);


}
