package com.codewithnavkant.blog.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithnavkant.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
