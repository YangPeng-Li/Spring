package com.componentscan.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lyp.config.MainConfig;
import com.lyp.config.MainConfig2;
import com.lyp.entiry.Person;

public class ComponentScanTest {
	
		
	
	
	@Test
	public void test_ScopeAndPrototy() 
	{
		
		@SuppressWarnings("resource")
		 AnnotationConfigApplicationContext annotationConfigapplication = new 	AnnotationConfigApplicationContext (MainConfig2.class);
		Person person = (Person) annotationConfigapplication.getBean("personScope");
		Person person1 = (Person) annotationConfigapplication.getBean("personScope");
		System.out.println(person == person1); //false 
	}
	

		@SuppressWarnings({ "resource", "unused" })
		@Test
		public void Test01 ()
		{
			 AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
			 Person bean = annotationConfigApplicationContext.getBean(Person.class);
			 
			 //获取所有 组件名称
			 String[] beanNamesForType = annotationConfigApplicationContext.getBeanDefinitionNames();
			 for (String names:beanNamesForType)
			 {
				 System.out.println(names);
			 }
		}
}
