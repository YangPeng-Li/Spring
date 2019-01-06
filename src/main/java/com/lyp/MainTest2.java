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
	 * Scope ��ʵ�� ��֤bean 
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
		//��ȡ����ϵͳ������
		Environment environment = annotationConfigApplication.getEnvironment();
		String property = environment.getProperty("os.name");
		System.out.println("��ȡ��ǰ����ϵͳ������---->"+property);
		
		
		//��ȡBean �е���Ϣ
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
		
		//�����ȡ����ColorBeanFactory�����Color
		Color bean3 = (Color) annotationConfigApplication.getBean("colorBeanFactory");
		Color bean33 = (Color) annotationConfigApplication.getBean("colorBeanFactory");
			
		//���Ҫ��ȡcolorBeanFactory ��bean ��Ҫ��ǰ���"&"  ����ֱ��.getclass()
		ColorBeanFactory bean4 = (ColorBeanFactory) annotationConfigApplication.getBean("&colorBeanFactory");
		System.out.println(bean2.getClass());
		System.out.println(bean3 == bean33); //�ж��Ƿ��ǵ�ʵ����bean 
		System.out.println("��ȡcolorBeanFactory��bean----->"+bean3.getClass());
		System.out.println("��ȡ&colorBeanFactory��bean----->"+bean4.getClass());
		
	}
}
 