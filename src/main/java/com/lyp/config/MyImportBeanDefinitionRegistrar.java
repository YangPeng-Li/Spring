package com.lyp.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.lyp.entiry.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	/**
	 * AnnotationMetadata 当前注册类信息
	 * BeanDefinitionRegistry   Bean定义注册类信息；
	 * 		把所有需要的添加到容器中的Bean, registerBeanDefinitionRegistry手工注册进来
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean bean1 = registry.containsBeanDefinition("com.lyp.entiry.Blue");
		boolean bean2 = registry.containsBeanDefinition("com.lyp.entiry.Red");
		if(bean1 && bean2 )
		{	
			//指定Bean定义信息，（Bean 类型，bean）
			//子类bean 需要指定父类的Bean
			//父类的bean 则不需要
			//ChildBeanDefinition rootBeanDefinition = new ChildBeanDefinition("");
			BeanDefinition  rootBeanDefinition = new RootBeanDefinition(RainBow.class);
			//注册一个RainBow Bean，指定bean的名字
			registry.registerBeanDefinition("RainBow", rootBeanDefinition);
		}
		
	}

}
