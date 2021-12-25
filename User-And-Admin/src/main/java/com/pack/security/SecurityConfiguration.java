package com.pack.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	/*@Autowired
	private BCryptPasswordEncoder encoder;
*/
	@Bean
	public BCryptPasswordEncoder getEncoder()
	{
		return new BCryptPasswordEncoder();
	}


	
	public void configure(HttpSecurity tap)throws Exception
	{
		tap/*.authorizeRequests().antMatchers("/login""/login","/loanSearch**","applyLoan","/approveLoan**").hasAnyRole("ADMIN","USER")
		.anyRequest().permitAll()
		.and()*/
		.authorizeRequests().antMatchers("/h2-console/**","/registerUser/**").permitAll();
		//.httpBasic()
		/*.formLogin()
		.and()
		.csrf().disable();*/
        tap.csrf().disable();
        tap.headers().frameOptions().disable();


	}

	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("scott").password(encoder.encode("sathya")).roles("ADMIN")
		.and().withUser("shekher").password(encoder.encode("1234")).roles("ADMIN");

		auth.jdbcAuthentication().dataSource(dataSource())
		.usersByUsernameQuery("select username, password, enabled"
				+ " from users where username=?")
		.authoritiesByUsernameQuery("select username, authority "
				+ "from authorities where username=?")
		.passwordEncoder(encoder);



	}

	@Bean
	public  DataSource   dataSource() {

		DriverManagerDataSource   ds =new  DriverManagerDataSource();
		ds.setDriverClassName("org.h2.Driver");
		ds.setUrl("jdbc:h2:mem:scott");
		ds.setUsername("sa");
		ds.setPassword("sa");
		return ds;
	}
*/
}
