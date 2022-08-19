package com.example.BackendService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class BackendServiceApplication {

//	private static final Logger log = LoggerFactory.getLogger(SpringBootHibernateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendServiceApplication.class, args);
	}

}
