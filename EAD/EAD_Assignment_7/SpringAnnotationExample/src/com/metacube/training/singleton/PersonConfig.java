package com.metacube.training.singleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PersonConfig {

	@Bean
	@Scope("singleton")
	public Person personSingleton() {
		return new Person();
	}
	
	
	@Bean
	@Scope("prototype")
	public Person personPrototype() {
		return new Person();
	}
}
