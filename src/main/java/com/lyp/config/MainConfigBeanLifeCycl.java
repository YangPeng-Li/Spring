package com.lyp.config;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.lyp.entiry.Car;

	@ComponentScan("com.lyp.entiry")
	@Configuration
	public class MainConfigBeanLifeCycl {
		
		
		/**
		 * bean的生命周期   创建---初始化---销毁 
		 * 容器管理Bean的生命周期
		 * 我们可以自定义bean的生命周期方法，容器在Bean进行到当前生命周期的时候来调用我们自定义初始化方法和销毁方法
		 * 
		 * 
		 * 单实例：在容器启动的时候会创建对象
		 * 多实例：在每次调用bean的时候会创建对象
		 * 
		 * BeanPostProcessor.postProcessBeforeInitialization --
		 * 初始化：
		 * 		对象创建完成，并赋值好，调用初始化方法
		 * BeanPostProcessor.postProcessAfterInitialization
		 * 
		 * 销毁：	
		 * 		单实例：容器关闭的时候
		 * 		多实例：容器不会管理这个Bean,容器也不会去调用销毁方法
		 * 
		 * BeanpostProcessor 工作原理:
		 * 遍历得到容器中所有的BeanPostProcessor;挨个进行遍历beforInitialization
		 * 一旦返回null 跳出for 循环不会执行后面的BeanPostProcessor.ProcessorsBeforeInitialization	
		 *
		 * populateBean(beanName, mbd, instanceWrapper);给Bean进行属性赋值
		 * InitializationBean
		 * {
		 * 	applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
		 * 	invokeInitMethods(beanName, wrappedBean, mbd);//bean执行自定义初始化
		 * 	applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
		 * }
		 * 
		 * 1)、指定初始化和销毁方法：
		 * 			通过@bean 指定 initMethod 和detoryMethod;
		 * 2)、通过Bean 实现InitializingBean （定义初始化逻辑）
		 * 				  DisposableBean（定义销毁逻辑）
		 * 3)、可以使用JSR250:
		 * @PosConstruct ： 在bean 创建完成并且属性复制完成，来执行初始化方法
		 * @PreDestroy ：在容器销毁bean之前通知我们进行清理工作
		 * 
		 * 4)、BeanPostProcessor【interface】 bean 的后置处理器
		 * 			在bean初始化前后进行处理一些工作：
		 *	    postProcessBeforeInitialization 在初始化之前进行工作
		 *			 
		 *		postProcessAfterInitialization 在初始化之后工作
	s	 *     
		 *      Spring 的底层使用 BeanPostProcessor
		 * @return
		 */
		
		@Scope("prototype")
		@Bean(initMethod="init",destroyMethod="destory")
		public Car car ()
		{
			return new Car ();
		}
}
