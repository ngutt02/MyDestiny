package com.pack.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class EmployeeService {


	private String noOfStudent;

	public String getNoOfStudent() {
		return noOfStudent;
	}

	public void setNoOfStudent(String noOfStudent) {
		this.noOfStudent = noOfStudent;
	}


}
