package com.lyp;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lyp.config.MainConfigBeanLifeCycl;

public class MainBeanLifeCycl {
	
	@SuppressWarnings("resource")
	@Test
	public void test_beanLifeCycl()
	{
	  System.out.println("容器开始创建");
	  AnnotationConfigApplicationContext ApplicationContext = new 	AnnotationConfigApplicationContext(MainConfigBeanLifeCycl.class);
	  System.out.println("容器创建完成");
	/*  Object bean = ApplicationContext.getBean("car");
	  System.out.println(bean.getClass());*/
	  
	  /**
	   * 单实例的bean 在 ApplicationContext.close();关闭的时候 IOC容器中的bean会被销毁
	   */
	  ApplicationContext.close();
	}
	
	
}
