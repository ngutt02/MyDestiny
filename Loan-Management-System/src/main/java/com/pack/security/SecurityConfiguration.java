package com.pack.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {



	
	
	@Autowired
	private BCryptPasswordEncoder encoder;



	public void configure(HttpSecurity tap)throws Exception
	{

		tap.authorizeRequests().antMatchers("/applyLoan/**","/searchLoan/**").hasAnyRole("USER")
		.and().authorizeRequests().antMatchers("/approveLoan/**","/rejectLoan/**").hasAnyRole("ADMIN")
		
		.anyRequest().permitAll()
		.and()
		
		
		.formLogin()
		
		.and()
		.csrf().disable();


		tap.headers().frameOptions().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
     
		

		auth.jdbcAuthentication().dataSource(dataSource())
		.usersByUsernameQuery("SELECT EMAIL,PASSWORD,ENABLED" 
		+ " FROM USER_TABLE WHERE EMAIL=?")
		.authoritiesByUsernameQuery("SELECT EMAIL,AUTHORITY" + 
				" FROM USER_TABLE WHERE EMAIL=?")
		.passwordEncoder(encoder);

	
	}


   
	public  DataSource dataSource() {
		DriverManagerDataSource   ds =new  DriverManagerDataSource();

		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:mem:loan");
		ds.setUsername("sa");
		ds.setPassword("sa");
		return ds;


		
	}


		




	
	}
