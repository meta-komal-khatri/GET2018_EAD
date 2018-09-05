package com.metacube.training.byconstructor;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
	private SpellChecker spellChecker;
	private String checking;
	
	
	@Autowired
	public TextEditor(SpellChecker spellChecker,String checking) {
		System.out.println("inside text editor");
		this.spellChecker=spellChecker;
		this.checking=checking;
	}
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
