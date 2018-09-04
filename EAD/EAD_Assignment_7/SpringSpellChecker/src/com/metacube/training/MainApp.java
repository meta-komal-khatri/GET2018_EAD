package com.metacube.training;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String args[]){
	/*	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		TextEditor textEditor=(TextEditor) context.getBean("textEditor");
		System.out.println(textEditor.getSpellChecking().getSpellChecking());
		
		
		
		ApplicationContext contextAutoWirirngByName=new ClassPathXmlApplicationContext("auto_wiring_by_name.xml");
		TextEditor textEditorAutoWiringByName=(TextEditor) contextAutoWirirngByName.getBean("textEditor");
		System.out.println(textEditorAutoWiringByName.getSpellChecking().getSpellChecking());
		
		
		ApplicationContext contextAutoWirirngByType=new ClassPathXmlApplicationContext("auto_wiring_by_type.xml");
		TextEditor textEditorAutoWiringByType=(TextEditor) contextAutoWirirngByType.getBean("textEditor");
		System.out.println(textEditorAutoWiringByType.getSpellChecking().getSpellChecking());
		
		
		ApplicationContext contextAutoWirirngByConstructor=new ClassPathXmlApplicationContext("auto_wiring_by_constructor.xml");
		TextEditor textEditorAutoWiringByconstructor=(TextEditor) contextAutoWirirngByConstructor.getBean("textEditor");
		System.out.println(textEditorAutoWiringByconstructor.getSpellChecking().getSpellChecking());
		
		*/
		ApplicationContext contextCollectionInjectionList=new ClassPathXmlApplicationContext("collection_injection.xml");
		CollectionInjection collectionInjection=(CollectionInjection) contextCollectionInjectionList.getBean("collectionInjection");
		for(SpellChecker spellChecker:collectionInjection.getSpellChecking()){
			System.out.println(spellChecker.getSpellChecking());
		}
		for(SpellChecker spellChecker:collectionInjection.getSpellCheckingSet()){
			System.out.println("Set"+spellChecker.getSpellChecking());
		}
		  for (Map.Entry<Integer,SpellChecker> entry : collectionInjection.getSpellCheckingMap().entrySet()){
			  System.out.println("Map"+entry.getValue().getSpellChecking());
		  }
		
		  ApplicationContext contextPerson=new ClassPathXmlApplicationContext("person_bean.xml");
		  Person person=(Person) contextPerson.getBean("person");
		  System.out.println(person.getTypeOfPerson());
		  person.setTypeOfPerson("Bad Person");
		  System.out.println(person.getTypeOfPerson());
		  Person person2=(Person) contextPerson.getBean("person");
		  System.out.println(person2.getTypeOfPerson());
		  
		  Person person3=(Person) contextPerson.getBean("person1"); 
		  System.out.println(person3.getTypeOfPerson());
		  person3.setTypeOfPerson("Bad Person");
		  System.out.println(person3.getTypeOfPerson());
		  Person person4=(Person) contextPerson.getBean("person1");
		  System.out.println(person4.getTypeOfPerson());
		  
	}
}
