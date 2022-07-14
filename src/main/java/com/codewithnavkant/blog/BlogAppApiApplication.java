package com.codewithnavkant.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogAppApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApiApplication.class, args);
	}

	 // @bean used for Spring container will create object automaticall and it will provide the
			// details there where we will do it autowired
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();

	}

}
