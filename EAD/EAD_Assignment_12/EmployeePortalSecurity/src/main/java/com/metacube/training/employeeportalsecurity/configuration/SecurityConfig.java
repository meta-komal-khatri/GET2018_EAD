package com.metacube.training.employeeportalsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;


@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {	

		auth.inMemoryAuthentication().withUser("anurag").password("{noop}123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("employee").password("{noop}123456").roles("EMPLOYEE");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {


		http.authorizeRequests().
		antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')").
		antMatchers("/employee/*").access("hasRole('ROLE_EMPLOYEE')").
		and().formLogin().  //login configuration
		loginPage("/login").
		loginProcessingUrl("/Login").
		defaultSuccessUrl("/default").	
		failureUrl("/error").
		and().logout().logoutUrl("/Logout")//logout configuration
		.logoutSuccessUrl("/login")	;
	
	}
}