package com.pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class DataBaseConnectionPoolingDbcp2Application implements CommandLineRunner{

	@Autowired
	HikariDataSource hikari;


	/*@Autowired
	private  BasicDataSource bd;*/

	/*@Autowired
	DriverManagerDataSource dm;*/
	/*@Autowired
	private DataSource datasource;*/
	public static void main(String[] args) {
		SpringApplication.run(DataBaseConnectionPoolingDbcp2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*System.out.println("DataSource:"+datasource);*/
		/*System.out.println("DataSource implemenatation BasicDataSource:"+bd);*/
		/*System.out.println("DataSource implemenatation DriverMangerDataSource:"+dm);*/

		System.out.println("DataSource implemenatation HikariDataSource:"+hikari);
	}

}
