package com.codewithnavkant.blog.services;

import java.util.List;

import com.codewithnavkant.blog.entities.Post;
import com.codewithnavkant.blog.payloads.PostDto;
import com.codewithnavkant.blog.payloads.PostResponse;

public interface PostService {

	// Create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	// Update

	PostDto updatePost(PostDto postDto, Integer postId);

	// delete

	void deletePost(Integer postId);

	// get All Post

	List<PostDto> getAllPost();

	// getAllPostByPaginationMethod
	List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);

	// PaginationByUsingPostResponseClass
	PostResponse getAllPost1(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	// get single post

	PostDto getPostById(Integer postId);

	// get all post by category

	List<PostDto> getAllPostByCategoryId(Integer categoryId);

	// get all post by User

	List<PostDto> getAllPostByUserId(Integer userId);

	// Search Posts

	List<PostDto> searchPost(String Keyword);

}
