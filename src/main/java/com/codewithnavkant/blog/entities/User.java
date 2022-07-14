package com.codewithnavkant.blog.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // to change the name write @Entity(name="new name")
@Table(name = "users")
//to change the name of table @Table(name="")
@NoArgsConstructor
@Getter
@Setter
public class User {
	@Id // This annotation has been used for primary key
	@GeneratedValue(strategy = GenerationType.AUTO) // Auto increment
	private int Id;
	// To change the name of any column
	@Column(name = "user_name", nullable = false, length = 100)	
	private String name;
	private String email;
	private String Password;
	private String about;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Post> posts = new ArrayList<>();

}
