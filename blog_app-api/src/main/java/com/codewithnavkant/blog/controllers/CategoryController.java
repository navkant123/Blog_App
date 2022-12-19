package com.codewithnavkant.blog.controllers;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithnavkant.blog.payloads.ApiResponse;
import com.codewithnavkant.blog.payloads.CategoryDto;
import com.codewithnavkant.blog.payloads.UserDto;
import com.codewithnavkant.blog.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// Post
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto createCategoryDto = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);

	}

	// Update Categroy
	@PutMapping("{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable("categoryId") Integer categoryId) {
		CategoryDto updatedCategoryDto = this.categoryService.updatedCategory(categoryDto, categoryId);
		return ResponseEntity.ok(updatedCategoryDto);

	}

	// delete
	@DeleteMapping("{categoryId}")
	public ResponseEntity<ApiResponse> deletCategory(@PathVariable("categoryId") Integer categoryId) {
		this.categoryService.deleteCategory(categoryId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted suceessfully !", true), HttpStatus.OK);

	}

	// GetAllUser
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory() {
		return ResponseEntity.ok(this.categoryService.getAllCategory());

	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable Integer categoryId) {
		return ResponseEntity.ok(this.categoryService.getCategoryById(categoryId));

	}

}
