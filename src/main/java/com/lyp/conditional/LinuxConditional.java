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
		//1.��ȡbean ����
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		//2.��ȡ�������
		ClassLoader classLoader = context.getClassLoader();
		//3.��ȡ��ǰ����ʱ����ϵͳ
		Environment environment = context.getEnvironment();
		//4.��ȡbean �����ע����
		BeanDefinitionRegistry registry = context.getRegistry();
		boolean containsBeanDefinition = registry.containsBeanDefinition("person");
		System.out.println("�Ƿ����person��bean"+containsBeanDefinition);
		String property = environment.getProperty("os.name");
		if(property.contains("linux"))
		{
			return true;
		}
		
		return false;
	}

}
