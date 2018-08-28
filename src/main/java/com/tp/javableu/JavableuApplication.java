package com.tp.javableu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.tp.*"})
@SpringBootApplication
public class JavableuApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavableuApplication.class, args);
	}
}
