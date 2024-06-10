package com.quocdat.java5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Java5Application {

	public static void main(String[] args) {
		SpringApplication.run(Java5Application.class, args);
	}

}
