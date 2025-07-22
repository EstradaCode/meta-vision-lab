package com.metavisionlab.SpringBootTest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.metavisionlab")
public class SpringBootTest1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTest1Application.class, args);
	}

}
