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
	 * AnnotationMetadata ��ǰע������Ϣ
	 * BeanDefinitionRegistry   Bean����ע������Ϣ��
	 * 		��������Ҫ����ӵ������е�Bean, registerBeanDefinitionRegistry�ֹ�ע�����
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean bean1 = registry.containsBeanDefinition("com.lyp.entiry.Blue");
		boolean bean2 = registry.containsBeanDefinition("com.lyp.entiry.Red");
		if(bean1 && bean2 )
		{	
			//ָ��Bean������Ϣ����Bean ���ͣ�bean��
			//����bean ��Ҫָ�������Bean
			//�����bean ����Ҫ
			//ChildBeanDefinition rootBeanDefinition = new ChildBeanDefinition("");
			BeanDefinition  rootBeanDefinition = new RootBeanDefinition(RainBow.class);
			//ע��һ��RainBow Bean��ָ��bean������
			registry.registerBeanDefinition("RainBow", rootBeanDefinition);
		}
		
	}

}
