package com.metacube.training.employeeportalsecurity.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	 @Autowired
	 DataSource dataSource;
	 
	@Autowired
	@Qualifier("CustomEmployeeDetailService")
	UserDetailsService userDetailsService;


	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailsService);
		
		auth.authenticationProvider(authenticationProvider());
	}


//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		
//		return new BCryptPasswordEncoder();
//	}


	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return authenticationProvider;
	}
		
//		 
		 @Autowired
		 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		   auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(NoOpPasswordEncoder.getInstance())
		  .usersByUsernameQuery(
		   "select employee_code as username,password,enabled from employee where employee_code=?")
		  .authoritiesByUsernameQuery(
		   "select employee_code,role from role where employee_code=?");
		 } 
	//	@Autowired
	//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {	
	//
	//		auth.inMemoryAuthentication().withUser("anurag").password("{noop}123456").roles("ADMIN");
	//		auth.inMemoryAuthentication().withUser("employee").password("{noop}123456").roles("EMPLOYEE");
	//
	//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {


		http.authorizeRequests().
		antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')").
		antMatchers("/employee/*").access("hasRole('ROLE_EMPLOYEE')").
		and().formLogin().
	
		//login configuration
		loginPage("/login").
		loginProcessingUrl("/Login").
		defaultSuccessUrl("/default").
	
		//		failureUrl("/error").
		
		usernameParameter("username").
		passwordParameter("password").
		and().logout().logoutUrl("/Logout")//logout configuration
		.logoutSuccessUrl("/login");

	}
}