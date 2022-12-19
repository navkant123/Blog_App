package com.codewithnavkant.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Used for data transfer
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	private int Id;

	// @NotNull
	@NotEmpty
	@Size(min = 4, message = "name should be with minimum length 4 !!")
	private String name;

	@Email
	@NotEmpty
	// @Pattern
	private String email;

	// @NotNull
	@NotEmpty
	@Size(min = 8, max = 15, message = "Password should be with minimum 8 and maximum 15 letters !!")
	private String password;

	@NotEmpty
	@Size(min = 8, message = "About should have  minimum length 8 !!")
	private String about;

}
