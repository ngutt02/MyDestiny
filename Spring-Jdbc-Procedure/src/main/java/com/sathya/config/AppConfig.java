package com.sathya.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages="com.sathya")
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Autowired
	Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dmds=new DriverManagerDataSource();
		dmds.setDriverClassName(env.getProperty("spring.jdbc.driver"));
		dmds.setUrl(env.getProperty("spring.jdbc.url"));
		dmds.setUsername(env.getProperty("spring.jdbc.username"));
		dmds.setPassword(env.getProperty("spring.jdbc.password"));
		return dmds;

	}

	@Bean
	public SimpleJdbcCall sjdc() {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource());
		return simpleJdbcCall;
	}
}
