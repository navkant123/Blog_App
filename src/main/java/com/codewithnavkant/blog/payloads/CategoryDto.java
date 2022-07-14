package com.codewithnavkant.blog.payloads;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private int categoryId;
	
	@NotEmpty
	@Size(min=8, message="Title length should not be less than 8 !!")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min=8, message="Title length should not be less than 8 !!")
	private String categoryDescription;
}
