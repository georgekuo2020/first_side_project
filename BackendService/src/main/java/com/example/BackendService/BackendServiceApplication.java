package com.example.BackendService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@OpenAPIDefinition(info = @Info(title = "First Side Project !!", version = "1.0.0"))
public class BackendServiceApplication {

//	private static final Logger log = LoggerFactory.getLogger(SpringBootHibernateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendServiceApplication.class, args);
	}

}
