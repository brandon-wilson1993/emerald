package com.emerald.emerald;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.emerald.api.*")
@EnableJpaRepositories("com.emerald.api.*")
@ComponentScan(basePackages = "com.emerald.api.*")
public class EmeraldApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(EmeraldApplication.class, args);
	}

}
