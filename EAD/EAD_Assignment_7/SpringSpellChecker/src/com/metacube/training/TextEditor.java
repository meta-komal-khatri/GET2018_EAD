package com.metacube.training;

public class TextEditor {
	private SpellChecker spellChecking;

	public TextEditor(){
		
	}
	public TextEditor(SpellChecker spellChecking){
		this.spellChecking=spellChecking;
	}
	/**
	 * @return the spellChecking
	 */
	public SpellChecker getSpellChecking() {
		return spellChecking;
	}

	/**
	 * @param spellChecking the spellChecking to set
	 */
	public void setSpellChecking(SpellChecker spellChecking) {
		this.spellChecking = spellChecking;
	}

	
	
}
