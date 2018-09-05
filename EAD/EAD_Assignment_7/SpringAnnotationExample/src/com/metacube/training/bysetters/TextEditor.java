package com.metacube.training.bysetters;

import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.training.byproperties.SpellChecker;

public class TextEditor {
	private SpellChecker spellChecker;
	
	private String checking;
	
	/**
	 * @param spellChecker the spellChecker to set
	 */
	@Autowired
	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println("inside setter of spell checker of texteditor");
		this.spellChecker = spellChecker;
	}
	/**
	 * @param checking the checking to set
	 */
	public void setChecking(String checking) {
		this.checking = checking;
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
