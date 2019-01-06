package com.lyp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import com.lyp.config.MainConfig;
import com.lyp.entiry.Person;

public class MainTest {
	
	@SuppressWarnings("resource")
	public static void main (String [] args)
	{
	/*	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Person p =  (Person) applicationContext.getBean("person");
		System.out.println(p);*/
		
		
		ApplicationContext applicationContext  =	new  AnnotationConfigApplicationContext(MainConfig.class);
	/*	Person p  =	 applicationContext.getBean(Person.class);
		System.out.println(p);
		
		
		String [] nameFcty = 	 applicationContext.getBeanNamesForType(Person.class);
 		
		for (String names : nameFcty)
		{
			System.out.println(names);
		}*/
		
	}
	
}
