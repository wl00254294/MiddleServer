package com.middle.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MiddleServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiddleServerApplication.class, args);
	}

}
