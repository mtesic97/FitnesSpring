package com.FitnesWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("model")
public class FitnesWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnesWebApplication.class, args);
	}

}
