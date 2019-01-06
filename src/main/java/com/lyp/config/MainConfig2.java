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
 * 放在类上对类进行统一设置
 * @author Administrator
 *
 */
//满足当前条件，则执行下面
@Conditional(WindowsConditional.class)
@Configuration
//@Import(com.lyp.entiry.Color.class)
@Import({Color.class,Red.class,MyImporSelect.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {
	/**
	 * 
	 * @Scope 调整作用域
	 * @since 4.2
	 * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
	 * @see #value
	 * 
	 * prototype： 多实例的 
	 * singleton： 单实例的（默认值） ,IOC容器启动会调用(Scope的value值是single)方法创建对象方法在IO容器中，
	 * 			     以后每次获取就直接在容器中(map.get（）)拿取
	 * request 	： 同一个请求创建一个请求
	 * session 	：同一个session创建一个实例
	 * 懒加载：
	 * 		单实例bean ，默认在容器启动的时候创建对象；
	 * 		懒加载：容器启动不创建对象。第一次使用（获取）Bean创建对象，并初始化。
	 * @Conditional ：能按照一定的条件进行注册，满足调价
	 */
	
	//private static Logger logger = org.slf4j.LoggerFactory.getLogger(Person.class);
	//日志
	private static final Logger logger = LoggerFactory.getLogger(Person.class);
	
	//@Scope("prototype")
	@Lazy
	@Bean("person")
	public Person person () 
	{ 	
		//PropertyConfigurator.configure("D:/STSProject/workSpace20180427/Spring-annotation/src/main/resources/log4j.properties");//加载.properties文件
		
		logger.trace("给容器添加person");
		System.out.println("给容器添加person");
		return new  Person("Miacle",28);
	}
	
	
	
	/**
	 * 根据系统运行环境使用不同的bean
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
	 * 给容器中注册组件
	 * 1)、报扫描+组件标注注解
	 * 		（@Controller+@Service+@Component+@Respository）【自己写的类】
	 * 2)、@Bean [导入第三方的组件]
	 * 3)、Import[快速给容器中导入一个组件 ]
	 * 		1)、@Import(要导入到容器中的组件)，容器中就会注册这个组件,id默认是全类名
	 * 		2)、ImportSelector:返回需要导入组件的全类名
	 * 		3)、ImportBeanDefinitionRegistrar
	 * 		   ImportBeanDefinitionRegistrar
	 * 
	 * 4)使用SPring提供的FactoryBean （工厂bean）
	 * 		 1)、默认获取到的Bean是getObject创建的对象
	 * 		 2)、获取beanFactory本身需要在前面添加 “&” “&colorBeanFactory”
	 * 
	 * 
	 */
	@Bean
	public 	 ColorBeanFactory colorBeanFactory() 
	{
		return new ColorBeanFactory();
	}
	
	
}
