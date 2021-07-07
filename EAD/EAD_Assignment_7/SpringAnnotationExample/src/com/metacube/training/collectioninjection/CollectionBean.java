package com.metacube.training.collectioninjection;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

public class CollectionBean {
	@Autowired
	private List<String> nameList;
	@Autowired
	private Set<String> nameSet;
	@Autowired
	private Map<Integer,String> nameMap;

	/**
	 * @return the nameList
	 */
	
	public List<String> getNameList() {
		return nameList;
	}

	/**
	 * @param nameList the nameList to set
	 */
	
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	/**
	 * @return the nameSet
	 */
	public Set<String> getNameSet() {
		return nameSet;
	}

	/**
	 * @param nameSet the nameSet to set
	 */
	public void setNameSet(Set<String> nameSet) {
		this.nameSet = nameSet;
	}

	/**
	 * @return the nameMap
	 */
	public Map<Integer,String> getNameMap() {
		return nameMap;
	}

	/**
	 * @param nameMap the nameMap to set
	 */
	public void setNameMap(Map<Integer,String> nameMap) {
		this.nameMap = nameMap;
	}
	
}
