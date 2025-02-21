package com.example.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class RestApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RestApplication.class);
		app.setDefaultProperties(Collections.singletonMap("spring.jackson.serialization.FAIL_ON_EMPTY_BEANS", "false"));
		app.run(args);
	}
}

