package com.lyp;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lyp.config.MainConfigBeanLifeCycl;

public class MainBeanLifeCycl {
	
	@SuppressWarnings("resource")
	@Test
	public void test_beanLifeCycl()
	{
	  System.out.println("������ʼ����");
	  AnnotationConfigApplicationContext ApplicationContext = new 	AnnotationConfigApplicationContext(MainConfigBeanLifeCycl.class);
	  System.out.println("�����������");
	/*  Object bean = ApplicationContext.getBean("car");
	  System.out.println(bean.getClass());*/
	  
	  /**
	   * ��ʵ����bean �� ApplicationContext.close();�رյ�ʱ�� IOC�����е�bean�ᱻ����
	   */
	  ApplicationContext.close();
	}
	
	
}
