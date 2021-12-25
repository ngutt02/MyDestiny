package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDatabaseOperationApplication {

	public static void main(String[] args) {
		System.out.println("before run");
		SpringApplication.run(SpringDatabaseOperationApplication.class, args);
		System.out.println("after run");
	}

}
