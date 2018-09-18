package com.metacube.training.employeeportalsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
		antMatchers("/admin**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')").
		and().formLogin().  //login configuration
                loginPage("/admin/login").
                loginProcessingUrl("/adminLogin").
                defaultSuccessUrl("/admin/security").	
		and().logout().    //logout configuration
		logoutUrl("/adminLogout"). 
		logoutSuccessUrl("/admin/login");
//		http.authorizeRequests()
//		.antMatchers("/admin/security**").access("hasRole('ROLE_ADMIN')")
//		//.antMatchers("/dba").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
//		.and().formLogin();
//		http
//		.formLogin()
//		.loginPage("/login.html") 
//		.loginProcessingUrl("/admin/login")
//		.defaultSuccessUrl("/security",true) 
//		.failureUrl("/login.html?error=true");

//		http.authorizeRequests()
//		.antMatchers("admin/security**").access("hasRole('ROLE_ADMIN')")
//		//.antMatchers("/dba").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
//		.and().formLogin();
	}
}