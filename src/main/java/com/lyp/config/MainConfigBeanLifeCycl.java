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
		 * bean����������   ����---��ʼ��---���� 
		 * ��������Bean����������
		 * ���ǿ����Զ���bean���������ڷ�����������Bean���е���ǰ�������ڵ�ʱ�������������Զ����ʼ�����������ٷ���
		 * 
		 * 
		 * ��ʵ����������������ʱ��ᴴ������
		 * ��ʵ������ÿ�ε���bean��ʱ��ᴴ������
		 * 
		 * BeanPostProcessor.postProcessBeforeInitialization --
		 * ��ʼ����
		 * 		���󴴽���ɣ�����ֵ�ã����ó�ʼ������
		 * BeanPostProcessor.postProcessAfterInitialization
		 * 
		 * ���٣�	
		 * 		��ʵ���������رյ�ʱ��
		 * 		��ʵ������������������Bean,����Ҳ����ȥ�������ٷ���
		 * 
		 * BeanpostProcessor ����ԭ��:
		 * �����õ����������е�BeanPostProcessor;�������б���beforInitialization
		 * һ������null ����for ѭ������ִ�к����BeanPostProcessor.ProcessorsBeforeInitialization	
		 *
		 * populateBean(beanName, mbd, instanceWrapper);��Bean�������Ը�ֵ
		 * InitializationBean
		 * {
		 * 	applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
		 * 	invokeInitMethods(beanName, wrappedBean, mbd);//beanִ���Զ����ʼ��
		 * 	applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
		 * }
		 * 
		 * 1)��ָ����ʼ�������ٷ�����
		 * 			ͨ��@bean ָ�� initMethod ��detoryMethod;
		 * 2)��ͨ��Bean ʵ��InitializingBean �������ʼ���߼���
		 * 				  DisposableBean�����������߼���
		 * 3)������ʹ��JSR250:
		 * @PosConstruct �� ��bean ������ɲ������Ը�����ɣ���ִ�г�ʼ������
		 * @PreDestroy ������������bean֮ǰ֪ͨ���ǽ���������
		 * 
		 * 4)��BeanPostProcessor��interface�� bean �ĺ��ô�����
		 * 			��bean��ʼ��ǰ����д���һЩ������
		 *	    postProcessBeforeInitialization �ڳ�ʼ��֮ǰ���й���
		 *			 
		 *		postProcessAfterInitialization �ڳ�ʼ��֮����
	s	 *     
		 *      Spring �ĵײ�ʹ�� BeanPostProcessor
		 * @return
		 */
		
		@Scope("prototype")
		@Bean(initMethod="init",destroyMethod="destory")
		public Car car ()
		{
			return new Car ();
		}
}
