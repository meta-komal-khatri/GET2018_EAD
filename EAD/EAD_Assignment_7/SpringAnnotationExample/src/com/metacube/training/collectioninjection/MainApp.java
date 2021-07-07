package com.metacube.training.collectioninjection;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	public static void main(String args[]) {
		ApplicationContext context=new AnnotationConfigApplicationContext(CollectionConfig.class);
		CollectionBean bean=(CollectionBean) context.getBean("collectionBean");
		for(String name:bean.getNameList()) {
			System.out.println(name);
		}
		
		for(String name:bean.getNameSet()) {
			System.out.println(name);
		}
		
		for(Map.Entry<Integer,String> name:bean.getNameMap().entrySet()) {
			System.out.println(name);
		}
	}
}
