package com.lyp;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.lyp.config.MainConfig2;
import com.lyp.entiry.Blue;
import com.lyp.entiry.Color;
import com.lyp.entiry.ColorBeanFactory;
import com.lyp.entiry.Person;


public class MainTest2 {
	
		
	AnnotationConfigApplicationContext annotationConfigApplication = new AnnotationConfigApplicationContext (MainConfig2.class);
	
	public void getBeansName(AnnotationConfigApplicationContext application) 
	{
		String[] beanDefinitionNames = application.getBeanDefinitionNames();
		for (String names :beanDefinitionNames )
		{
			System.out.println(names);
		}
	}
	
	
	/**
	 * Scope 多实例 验证bean 
	 */
	@Test
	public void test_ScopeAndPrototy() 
	{
		@SuppressWarnings("resource")
		 Object person = annotationConfigApplication.getBean("person");
		 Object person1 = annotationConfigApplication.getBean("person");
		 System.out.println(person == person1); //false 
	}
	
	

	
	
	@Test
	public void test_Conditional()
	{
		String[] beanNames = annotationConfigApplication.getBeanNamesForType(Person.class);
		for (String name : beanNames)
		{
			System.out.println(name);
		}
		//获取运行系统的名称
		Environment environment = annotationConfigApplication.getEnvironment();
		String property = environment.getProperty("os.name");
		System.out.println("获取当前操作系统的名称---->"+property);
		
		
		//获取Bean 中的信息
		Map<String ,Person> persons = annotationConfigApplication.getBeansOfType(Person.class);
		System.out.println(persons);
		
	}
	
	@Test
	public void test_Import() 
	{
		getBeansName(annotationConfigApplication);
		Blue bean = annotationConfigApplication.getBean(Blue.class);
		System.out.println(bean);
		
		ColorBeanFactory bean2 = annotationConfigApplication.getBean(ColorBeanFactory.class);
		
		//这里获取的是ColorBeanFactory里面的Color
		Color bean3 = (Color) annotationConfigApplication.getBean("colorBeanFactory");
		Color bean33 = (Color) annotationConfigApplication.getBean("colorBeanFactory");
			
		//如果要获取colorBeanFactory 的bean 需要在前面加"&"  或者直接.getclass()
		ColorBeanFactory bean4 = (ColorBeanFactory) annotationConfigApplication.getBean("&colorBeanFactory");
		System.out.println(bean2.getClass());
		System.out.println(bean3 == bean33); //判断是否是单实例的bean 
		System.out.println("获取colorBeanFactory的bean----->"+bean3.getClass());
		System.out.println("获取&colorBeanFactory的bean----->"+bean4.getClass());
		
	}
}
 