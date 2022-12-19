package com.codewithnavkant.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithnavkant.blog.entities.Category;
import com.codewithnavkant.blog.entities.Comment;
import com.codewithnavkant.blog.entities.Post;
import com.codewithnavkant.blog.exceptions.ResourceNotFoundException;
import com.codewithnavkant.blog.payloads.CommentDto;
import com.codewithnavkant.blog.repositiries.CommentRepo;
import com.codewithnavkant.blog.repositiries.PostRepo;
import com.codewithnavkant.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
//This is a commet service Implimentation
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post Id", postId));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment comment = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "comment Id", commentId));
		this.commentRepo.delete(comment);

	}

}
