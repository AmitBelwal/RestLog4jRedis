package com.proj.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RestLog4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestLog4jApplication.class, args);
	}

}
