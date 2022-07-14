package com.codewithnavkant.blog.repositiries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithnavkant.blog.entities.User;

//JPA Repository used for sorting, paging etc. for database operation in free

public  interface UserRepo extends JpaRepository<User, Integer> {

}
