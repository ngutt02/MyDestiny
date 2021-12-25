package com.pack.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
public class EmployeeSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	BCryptPasswordEncoder encoder;

	public void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().
		antMatchers("/delete**").hasAnyRole("ADMIN")
		.anyRequest().permitAll()
		.and()
		/*
		 * httpBasic():  configures  HTTP Basic Authentication
		 * formLogin(): configures  HTTP Form  Authentication
		 */
		//.httpBasic()
		.formLogin()


		/*
		 * formLogin()  provides a default login page to accept the credentials. If authentication fails then it provides
		 * default login page with error message.
		 * To customize the default login page, use this configuration
		 * loginPage() : To specify  url  to send users if login is required
		 * loginProcessingUrl(): To specify a url used in form action, to validate the credentials
		 * failureUrl():  To specify a url to redirect user, if login fails
		 */
		.loginPage("/loginPage").loginProcessingUrl("/doLogin").failureUrl("/login?error=Bad Credentials")
		.and()
		.exceptionHandling().accessDeniedPage("/WEB-INF/views/accessDenied")


		.and()
		.csrf().disable();
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder)throws Exception
	{
		/*builder.inMemoryAuthentication()
		 *.withUser("Scott").password(encoder.encode("12345")).roles("ADMIN")
		 *.and()
		 *.withUser("Miller").password(encoder.encode("6789")).roles("ACCOUNTANT");
		 */

		//Building AuthenticationManager with  Database Authentication details
		builder.jdbcAuthentication()
		.dataSource(ds())
		.usersByUsernameQuery("select username,password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username,authority from authorities where username=?")
		.passwordEncoder(encoder);


	}


	public   DataSource     ds() {
		DriverManagerDataSource   ds =new  DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}



	@Bean
	public BCryptPasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
}
