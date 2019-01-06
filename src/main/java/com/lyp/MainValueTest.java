package com.lyp;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lyp.config.MainConfigPropertyOfValue;
import com.lyp.entiry.Color;
import com.lyp.entiry.Person;

public class MainValueTest {
	
	@SuppressWarnings("resource")
	@Test
	public void  Test_PropertyValue () {
	 AnnotationConfigApplicationContext applicationContext = new 	AnnotationConfigApplicationContext(MainConfigPropertyOfValue.class);
	 Person bean = (Person) applicationContext.getBean("person");
	 System.out.println(bean);
	
	 Object boss = applicationContext.getBean("boss");
	 
	 Color bean2 = applicationContext.getBean(Color.class);
	 System.out.println("Color----¡·"+bean2);
	 
	 System.out.println(boss);
	 
	}
	
}
