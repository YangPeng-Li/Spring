package com.lyp.conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxConditional implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata)
	{
		//1.获取bean 工厂
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//2.获取类加载器
		ClassLoader classLoader = context.getClassLoader();
		//3.获取当前运行时环境系统
		Environment environment = context.getEnvironment();
		//4.获取bean 定义的注册类
		BeanDefinitionRegistry registry = context.getRegistry();
		boolean containsBeanDefinition = registry.containsBeanDefinition("person");
		System.out.println("是否包含person的bean"+containsBeanDefinition);
		String property = environment.getProperty("os.name");
		if(property.contains("linux"))
		{
			return true;
		}
		
		return false;
	}

}
