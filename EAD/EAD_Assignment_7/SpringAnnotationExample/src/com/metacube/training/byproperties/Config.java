package com.metacube.training.byproperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {
	
	@Bean
	public TextEditor textEditor() {
		return new TextEditor();
	}
	
	@Bean
	public SpellChecker spellChecker() {
		return new SpellChecker();
	}
}
