package com.lyp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.lyp.AOP.LogAspects;
import com.lyp.AOP.MathCalculator;

/**
 * 
 * com.lyp.config
 *	@author Lyp
 * Spring-annotation
 * 2018��11��27������8:10:37
 * 
 * AOP :����̬���� 
 *      ָ���������ڼ䶯̬�Ľ�ĳ�δ������뵽ָ������ָ��λ�����еı�̷�ʽ
 *      
 * 1������AOP ģ�� Spring AOP [Spring-aspects]
 * 2������һ��ҵ��   �߼���MathCalculator��[��ҵ���߼����е�ʱ����־���д�ӡ������֮ǰ���������н��������������쳣��]
 * 3������һ����־�����ࣨlogAspects��:������ķ�����Ҫ��̬��֪MathCalculator.div���е�ʲô�ط�
 * 	    ֪ͨ������
 * 			ǰ��֪ͨ��(@Befor)
 * 			����֪ͨ��(@After)
 * 			����֪ͨ��(@AfterReturning)
 * 			�쳣֪ͨ��(@AfterThrowing)
 * 			����֪ͨ��(@Around) ��̬�����ֶ��ƽ��������У�joinPoint.process��
 * 4��  ��������Ŀ�귽����ע��ʱ�ε����У�֪ͨע�⣩
 * 5�����������ҵ���߼��ࣨĿ�귽���ࣩ�����뵽������
 * ��
 * 6���������Spring �Ǹ����������ࣨ���������ϼ�һ��ע�⣩
 * ��
 * 7�����������м� @EnableAspectJAutoProxy ��������ע�������� 
 * 	Spring�кܶ�@EnableXXX
 * 
 * 
 * 
 * 
 * 
 * 
 * ������
 * 	1������ҵ���߼��������������뵽�����У�����Spring�Ǹ��������ࣨ@Aspect��
 * 	2�����������ϵ�ÿһ��֪ͨ�����ϱ�ע֪ͨע�����Spring,����Spring��ʱ�εص����У������ı��ʽ��
 * 	3�������������Ͽ�������AOP	ģʽ@EnableAspectJAutoProxy
 * 
 * 
 * AOPԭ������������ע����ʲô�����������ʲôʱ������������������ʱ���ܡ�
 * 		1��@EnableAspectJAutoProxy
 * 				@Import(AspectJAutoProxyRegistrar.class) ����������AspectJAutoProxyRegistrar
 * 				����AspectJAutoProxyRegistrar �Զ����������   ----��ע��bean
 * 				internalAutoProxyCreator ---������---> AnnotationAwareAspectJAutoProxyCreator  ===>internalAutoProxyCreator
 *				
 *				��������ע��һ�� (ע��װ��ģʽ�����Զ����� �Զ���������)[ע������ʶ�����Զ���������]AnnotationAwareAspectJAutoProxyCreator
 *				

 *		2��AnnotationAwareAspectJAutoProxyCreator extends AspectJAwareAdvisorAutoProxyCreator
 * 		  AspectJAwareAdvisorAutoProxyCreator extends AbstractAdvisorAutoProxyCreator
 * 		  AbstractAdvisorAutoProxyCreator extends AbstractAutoProxyCreator
 * 		  AbstractAutoProxyCreator extends ProxyProcessorSupport implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware 		
 * 		  -----> ��SmartInstantiationAwareBeanPostProcessor  [beanPostProcessor] =====>bean�ĺ��ô�����,��עbean ����ǰ��
 * 		  -----> ��BeanFactoryAware	 setBeanFactory 
 * 		 AbstractAutoProxyCreator.setBeanFactory();[ʵ����ķ���]
 * 		 AbstractAutoProxyCreator.postProcessBeforeInstantiation()�к��ô��������߼�[ʵ�����з���]
 * 			
 * 		 AbstractAdvisorAutoProxyCreator.setBeanFactory() --->initBeanFactory()
 * 		 AnnotationAwareAspectJAutoProxyCreator.initBeanFactory()
 * 		 
 * 
 * 
 * ���̣�
 * 		1���������ô���ioc���� 
 * 		2��ע�������࣬����refresh(),ˢ������;
 * 				  ==========>//Register bean processors that intercept bean creation.
				  ==========>registerBeanPostProcessors(beanFactory);
		3��PostProcessorRegistrationDelegate.registerBeanPostProcessors(beanFactory); ע��bean�ĺ��ô�������������bean�Ĵ���
 * 			1)��    PostProcessorRegistrationDelegate.registerBeanPostProcessors()��
 * 				 �Ȼ�ȡioc�����Ѿ����������Ҫ�����Ķ�������е�BeanPostProcessor ���Ի�ȡ��һ�º��ô���������Ϣ��
 * 				String[] postProcessorNames = beanFactory.getBeanNamesForType(BeanPostProcessor.class, true, false);
 * 				
 * 				org.springframework.context.annotation.internalAutowiredAnnotationProcessor
				org.springframework.context.annotation.internalRequiredAnnotationProcessor
				org.springframework.context.annotation.internalCommonAnnotationProcessor
				org.springframework.aop.config.internalAutoProxyCreator 
			2)���������мӱ��BeanPostProcessor
				beanFactory.addBeanPostProcessor(new BeanPostProcessorChecker(beanFactory, beanProcessorTargetCount));
 * 			3)��	����ע��ʵ����PriorityOrdered�ӿڵ�BeanProcessor
 * 				�ԵĴ���BeanProcessors��// Separate between BeanPostProcessors that implement PriorityOrdered,
						// Ordered, and the rest.��
				// First, register the BeanPostProcessors that implement PriorityOrdered.
				// Next, register the BeanPostProcessors that implement Ordered.
 * 			4)���ٸ�������ע�� ʵ����Order�ӿڵ�BeanProcessor��
 * 			5)����������ע����ͨ��BeanProccessor  ----->��BeanProcessor�����֣�[BeanPostProcessor pp = beanFactory.getBean(ppName, BeanPostProcessor.class)]Ȼ����
 * 			 ---��ν��ע����� [org.springframework.aop.config.internalAutoProxyCreator]
 * 			---����ͺ�ǰ���EnableAspectJAutoProxy ���ɵ� internalAutoProxyCreator �����˹�ϵ 
 * 				�����ȡ����Bean �ʹ��� Bean
 * 			6)��ע��BeanProcessor��ʵ�����Ǿ��Ǵ���BeanProcessor���󣬱����������У�
 * 				����internalAutoProxyCreator��BeanProcessor�����Ǵ���AnnotationAwareAspectJAutoProxyCreator����
 * 				1)������Bean��ʵ��
 * 				2)��populateBean(beanName, mbd, instanceWrapper);��bean�ĸ������Ը�ֵ
 * 				3)��initializeBean 
 * 						1)--->invokeAwareMethods(beanName, bean);����Aware�ӿڷ����Ļص�
 * 				 		2)--->applyBeanPostProcessorsBeforeInitialization();Ӧ��ǰ�ô������� ProcessorsBeforeInitialization �ķ��� ���õ����к��ô�����(ProcessorsBeforeInitialization)
 * 						3)--->invokeInitMethods(beanName, wrappedBean, mbd); ִ���Զ���ĳ�ʼ������
 * 						4)--->applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);ִ�к��ô�����postProcessAfterInitialization() 
 * 			7)����BeanPostProcessorע�ᵽBeabFactory
 * 			   beanFactory.addBeanPostProcessor(postProcessor); 
 * 							
 * 4��BeanPostProcessor��AnnotationAwareAspectJAutoProxyCreator�������ɹ�
 * =========================================�����Ǵ�����ע��	AnnotationAwareAspectJAutoProxyCreator�Ĺ���======================
 * 
 * 
 * 
 * 
 * 
 * 
 */						

//����  @EnableAspectJAutoProxy ====  <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
@EnableAspectJAutoProxy
@Configuration
public class MainConfigAOP {
	
	
	
	//ҵ���߼�	����������
	@Bean
	public MathCalculator mathCalculator ()
	{
		return new MathCalculator ();
	}
	//��������뵽������
	
	@Bean
	public LogAspects log () 
	{
		return new  LogAspects ();
	}
	

}
