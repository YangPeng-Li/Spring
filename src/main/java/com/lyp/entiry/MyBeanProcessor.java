package com.lyp.entiry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


/**
 * 后置处理器：bean初始化前后进行工作
 * 将后置处理器加入到容器中，就可以工作
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
