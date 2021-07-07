package com.metacube.training.collectioninjection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollectionConfig {
	
	@Bean
	public CollectionBean collectionBean() {
		return new CollectionBean();
	}
	
	@Bean 
	public List<String> nameList(){
		return Arrays.asList("Komal","Akshita","Ramji");
	}
	
	
	@Bean
	public Set<String> nameSet(){
		Set<String> nameSet=new HashSet<String>();
		nameSet.add("Komal");
		nameSet.add("Shivani");
		nameSet.add("Surbhi");
		return nameSet;


	}
	
	@Bean
	public Map<Integer,String> nameMap(){
		Map<Integer,String> nameMap=new HashMap<Integer,String>();
		nameMap.put(1, "Komal");
		nameMap.put(2, "Khatri");
		nameMap.put(3, "Komal");
		return nameMap;


	}
}
