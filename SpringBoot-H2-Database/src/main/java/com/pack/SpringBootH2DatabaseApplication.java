package com.pack;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableConfigurationProperties(EmployeeService.class)
public class SpringBootH2DatabaseApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootH2DatabaseApplication.class, args);

	}

	
	@PreDestroy
	public void close()
	{
		System.out.println("from destroy method");
	}
	


}
