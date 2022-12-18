package com.codewithnavkant.blog.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithnavkant.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
