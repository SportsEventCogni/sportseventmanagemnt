package com.project.sports.event.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication

@ComponentScan("com.*")
@EnableJpaRepositories(basePackages = {"com.*"})
@EntityScan(basePackages = {"com.*"})



public class SportsEventManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsEventManagementApplication.class, args);
	}

}
