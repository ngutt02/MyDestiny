package com.pack;



//import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceUtils;
//import org.springframework.jdbc.datasource
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LoanManagementSystemApplication {


	@Autowired
	private Environment env;
	public static void main(String[] args) {
		SpringApplication.run(LoanManagementSystemApplication.class, args);
	}
	/*@Bean
	public  DataSource dataSource() {
		DriverManagerDataSource   ds =new  DriverManagerDataSource();

		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:mem:loan");
		ds.setUsername("sa");
		ds.setPassword(" ");
		return ds;
	 */		//System.out.println("Before Class Name");
	//ds.setDriverClassName("org.h2.Driver");
	//System.out.println("After class Name");
	/*ds.setUrl("jdbc:h2:mem:user;AUTO_SERVER=TRUE");
		ds.setUsername("sa");
		ds.setPassword(" ");
		return ds;
	 */  		 

	/*ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;*/
	//}


	@Bean
	public BCryptPasswordEncoder getEncoder()
	{
		return new BCryptPasswordEncoder();
	}


	/* @Bean(initMethod = "start", destroyMethod = "stop")
	public Server inMemoryH2DatabaseaServer() throws SQLException {
		return Server.createTcpServer(
				"-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
	}
	 */

	/*@Bean
	public  DataSource dataSource() {
		DriverManagerDataSource   ds =new  DriverManagerDataSource();
		ds.setDriverClassName("spring.datasource.driver-class-name");
		ds.setUrl("spring.datasource.url");
		ds.setUsername("spring.datasource.username");
		ds.setPassword("spring.datasource.password");
		return ds;
	}
	 */
/*	@Bean
	public  DataSource dataSource() {

		DriverManagerDataSource d=new DriverManagerDataSource();
		d.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		d.setUrl(env.getProperty("spring.datasource.url"));
		d.setUsername(env.getProperty("spring.datasource.username"));
		d.setPassword(env.getProperty("spring.datasource.password"));
		return d;

	}
*/
}






