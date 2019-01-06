package com.lyp.entiry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


/**
 * ���ô�������bean��ʼ��ǰ����й���
 * �����ô��������뵽�����У��Ϳ��Թ���
 * @author Administrator
 *
 */
@Component
public class MyBeanProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		
		System.out.println("postProcessBeforeInitialization"+beanName);
		
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

		System.out.println("postProcessAfterInitialization"+beanName);
		return bean;
	}

}
