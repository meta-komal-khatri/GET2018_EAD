package com.metacube.training.byproperties;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
	@Autowired
	private SpellChecker spellChecker;
	
	private String checking;
	
	public SpellChecker getSpellChecker() {
		return spellChecker;
	}
	public String getChecking() {
		return checking;
	}
	public void printCheckin() {
		System.out.println(checking);
	}
	
	
}
