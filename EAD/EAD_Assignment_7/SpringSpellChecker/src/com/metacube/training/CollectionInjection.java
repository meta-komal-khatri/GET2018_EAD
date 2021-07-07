package com.metacube.training;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionInjection {
	private List<SpellChecker> spellChecking;
	private Set<SpellChecker> spellCheckingSet;
	private Map<Integer,SpellChecker> spellCheckingMap;
	
	/**
	 * @return the spellChecking
	 */
	public List<SpellChecker> getSpellChecking() {
		
		return spellChecking;
	}

	/**
	 * @param spellChecking the spellChecking to set
	 */
	public void setSpellChecking(List<SpellChecker> spellChecking) {
		this.spellChecking = spellChecking;
	}

	/**
	 * @return the spellCheckinhSet
	 */
	public Set<SpellChecker> getSpellCheckingSet() {
		return spellCheckingSet;
	}

	/**
	 * @param spellCheckinhSet the spellCheckinhSet to set
	 */
	public void setSpellCheckingSet(Set<SpellChecker> spellCheckingSet) {
		this.spellCheckingSet = spellCheckingSet;
	}

	/**
	 * @return the spellCheckingMap
	 */
	public Map<Integer,SpellChecker> getSpellCheckingMap() {
		return spellCheckingMap;
	}

	/**
	 * @param spellCheckingMap the spellCheckingMap to set
	 */
	public void setSpellCheckingMap(Map<Integer,SpellChecker> spellCheckingMap) {
		this.spellCheckingMap = spellCheckingMap;
	}
}
