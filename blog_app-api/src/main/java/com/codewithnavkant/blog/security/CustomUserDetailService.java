package com.codewithnavkant.blog.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codewithnavkant.blog.entities.User;
import com.codewithnavkant.blog.exceptions.ResourceNotFoundException;
import com.codewithnavkant.blog.repositiries.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stubloading user from database by username
		User user = this.userRepo.findByEmail(username)
				.orElseThrow(() -> new ResourceNotFoundException("User ", " email : " + username, 0));
		return user;

	}

}
