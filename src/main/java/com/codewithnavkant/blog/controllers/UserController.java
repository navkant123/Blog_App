package com.codewithnavkant.blog.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithnavkant.blog.payloads.ApiResponse;
import com.codewithnavkant.blog.payloads.UserDto;
import com.codewithnavkant.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;

	// Post -create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);

	}

	// PUT-Update User
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updatedUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid) { // @Pathvariable()
																													// Integer
																													// u
		UserDto updatedUser = this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);

	}

	// DELETE
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deletUser(@PathVariable Integer userId) {
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deletd Successfully", true), HttpStatus.OK);
	}
	// This method also can be used
	// public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
	// this.deleteUser(userId);
	// return ResponseEntity.ok(Map.of("message", "User deleted Successfully !"));
	// return new ResponseEntity(Map.of("message", "User deleted Successfully !"),
	// HttpStatus.OK);

	// }
	// GET
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getallUsers() {
		return ResponseEntity.ok(this.userService.getAllUsers());

	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId) {
		return ResponseEntity.ok(this.userService.getUserById(userId));

	}

}
