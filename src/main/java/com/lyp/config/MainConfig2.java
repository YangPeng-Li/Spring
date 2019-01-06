package com.lyp.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.lyp.conditional.LinuxConditional;
import com.lyp.conditional.WindowsConditional;
import com.lyp.entiry.Color;
import com.lyp.entiry.ColorBeanFactory;
import com.lyp.entiry.Person;
import com.lyp.entiry.Red;


/**
 * �������϶������ͳһ����
 * @author Administrator
 *
 */
//���㵱ǰ��������ִ������
@Conditional(WindowsConditional.class)
@Configuration
//@Import(com.lyp.entiry.Color.class)
@Import({Color.class,Red.class,MyImporSelect.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
	/**
	 * 
	 * @Scope ����������
	 * @since 4.2
	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
	 * @see #value
	 * 
	 * prototype�� ��ʵ���� 
	 * singleton�� ��ʵ���ģ�Ĭ��ֵ�� ,IOC�������������(Scope��valueֵ��single)�����������󷽷���IO�����У�
	 * 			     �Ժ�ÿ�λ�ȡ��ֱ����������(map.get����)��ȡ
	 * request 	�� ͬһ�����󴴽�һ������
	 * session 	��ͬһ��session����һ��ʵ��
	 * �����أ�
	 * 		��ʵ��bean ��Ĭ��������������ʱ�򴴽�����
	 * 		�����أ������������������󡣵�һ��ʹ�ã���ȡ��Bean�������󣬲���ʼ����
	 * @Conditional ���ܰ���һ������������ע�ᣬ�������
	 */
	
	//private static Logger logger = org.slf4j.LoggerFactory.getLogger(Person.class);
	//��־
	private static final Logger logger = LoggerFactory.getLogger(Person.class);
	
	//@Scope("prototype")
	@Lazy
	@Bean("person")
	public Person person () 
	{ 	
		//PropertyConfigurator.configure("D:/STSProject/workSpace20180427/Spring-annotation/src/main/resources/log4j.properties");//����.properties�ļ�
		
		logger.trace("���������person");
		System.out.println("���������person");
		return new  Person("Miacle",28);
	}
	
	
	
	/**
	 * ����ϵͳ���л���ʹ�ò�ͬ��bean
	 * 
	 * 
	 * 
	 */
	
	@Conditional(WindowsConditional.class)
	@Bean("bill")
	public Person person01() 
	{
		return new Person ("Bill",62);
	}
	
	
	@Conditional(LinuxConditional.class)
	@Bean("linus")
	public Person person02 ()
	{
		return new Person ("linus",62);
	}
	
	/*
	 * ��������ע�����
	 * 1)����ɨ��+�����עע��
	 * 		��@Controller+@Service+@Component+@Respository�����Լ�д���ࡿ
	 * 2)��@Bean [��������������]
	 * 3)��Import[���ٸ������е���һ����� ]
	 * 		1)��@Import(Ҫ���뵽�����е����)�������оͻ�ע��������,idĬ����ȫ����
	 * 		2)��ImportSelector:������Ҫ���������ȫ����
	 * 		3)��ImportBeanDefinitionRegistrar
	 * 		   ImportBeanDefinitionRegistrar
	 * 
	 * 4)ʹ��SPring�ṩ��FactoryBean ������bean��
	 * 		 1)��Ĭ�ϻ�ȡ����Bean��getObject�����Ķ���
	 * 		 2)����ȡbeanFactory������Ҫ��ǰ����� ��&�� ��&colorBeanFactory��
	 * 
	 * 
	 */
	@Bean
	public 	 ColorBeanFactory colorBeanFactory() 
	{
		return new ColorBeanFactory();
	}
	
	
}
