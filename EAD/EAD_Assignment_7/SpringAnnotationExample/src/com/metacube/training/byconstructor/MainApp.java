package com.metacube.training.byconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {
	public static void main(String args[]) {
		ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
		TextEditor editor=(TextEditor) context.getBean("textEditor");
		
		editor.getSpellChecker().spellChecking();
		editor.printCheckin();
	}

	
}
