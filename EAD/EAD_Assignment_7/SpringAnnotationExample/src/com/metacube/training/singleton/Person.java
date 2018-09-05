package com.metacube.training.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Person {
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	@Autowired
	@Value("komal")
	public void setName(String name) {
		this.name = name;
	}
}
