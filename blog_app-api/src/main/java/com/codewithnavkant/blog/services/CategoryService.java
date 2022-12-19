package com.codewithnavkant.blog.services;

import java.util.List;

import com.codewithnavkant.blog.payloads.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto category);

	CategoryDto updatedCategory(CategoryDto categoryDto, Integer categoryId);

	CategoryDto getCategoryById(Integer categoryId);

	List<CategoryDto> getAllCategory();

	void deleteCategory(Integer categoryId);

}
