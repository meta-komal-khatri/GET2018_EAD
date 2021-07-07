/**
 * 
 */
package com.metacube.training.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author popla
 *
 */
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(PersonConfig.class);
		Person person=(Person) context.getBean("personSingleton");
		System.out.println(person.getName());
		person.setName("rashi");
		System.out.println(person.getName());
		Person person1=(Person) context.getBean("personSingleton");
		System.out.println(person1.getName());
		
		System.out.println("*************************");
		
		ApplicationContext contextPrototype=new AnnotationConfigApplicationContext(PersonConfig.class);
		Person person2=(Person) context.getBean("personPrototype");
		System.out.println(person2.getName());
		person2.setName("rashi");
		System.out.println(person2.getName());
		Person person3=(Person) context.getBean("personPrototype");
		System.out.println(person3.getName());
		
	}

}
