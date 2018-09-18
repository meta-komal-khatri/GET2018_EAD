package com.metacube.training.employeeportalsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {		
		auth.inMemoryAuthentication().withUser("anurag").password("123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("employee").password("123456").roles("EMPLOYEE");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/*").access("hasRole('ROLE_ADMIN')")
			//.antMatchers("/").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_EMPLOYEE')")
			.and().formLogin();
		
	}
}