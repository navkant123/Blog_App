package com.codewithnavkant.blog.repositiries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codewithnavkant.blog.entities.Category;
import com.codewithnavkant.blog.entities.Post;
import com.codewithnavkant.blog.entities.User;
import com.codewithnavkant.blog.payloads.PostDto;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);

	List<Post> findByCategory(Category category);

	// searching
	@Query("select p from Post p where p.title like :key")
	List<Post> findByTitle(@Param("key") String title);
}
