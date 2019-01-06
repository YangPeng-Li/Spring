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
 * 2018年11月27日下午8:10:37
 * 
 * AOP :【动态代理】 
 *      指程序运行期间动态的将某段代码切入到指定方法指定位置运行的编程方式
 *      
 * 1、导入AOP 模块 Spring AOP [Spring-aspects]
 * 2、定义一个业务   逻辑（MathCalculator）[在业务逻辑运行的时候日志进行打印（方法之前，方法运行结束，方法出现异常）]
 * 3、定义一个日志切面类（logAspects）:切面类的方法需要动态感知MathCalculator.div运行到什么地方
 * 	    通知方法：
 * 			前置通知：(@Befor)
 * 			后置通知：(@After)
 * 			返回通知：(@AfterReturning)
 * 			异常通知：(@AfterThrowing)
 * 			环绕通知：(@Around) 动态代理手动推进方法运行（joinPoint.process）
 * 4、  给切面类目标方法标注何时何地运行（通知注解）
 * 5、将切面类和业务逻辑类（目标方法类）都加入到容器中
 * ★
 * 6、必须告诉Spring 那个类是切面类（给切面类上加一个注解）
 * ★
 * 7、给配置类中加 @EnableAspectJAutoProxy 开启基于注解切面类 
 * 	Spring中很多@EnableXXX
 * 
 * 
 * 
 * 
 * 
 * 
 * 三步：
 * 	1）、将业务逻辑组件和切面类加入到容器中，告诉Spring那个是切面类（@Aspect）
 * 	2）、在切面上的每一个通知方法上标注通知注解告诉Spring,告诉Spring何时何地的运行（切入点的表达式）
 * 	3）、在配置类上开启切面AOP	模式@EnableAspectJAutoProxy
 * 
 * 
 * AOP原理：【看容器中注册了什么组件，这个组件什么时候工作，这个组件工作的时候功能】
 * 		1、@EnableAspectJAutoProxy
 * 				@Import(AspectJAutoProxyRegistrar.class) 给容器导入AspectJAutoProxyRegistrar
 * 				利用AspectJAutoProxyRegistrar 自动定义给容器   ----》注册bean
 * 				internalAutoProxyCreator ---类型是---> AnnotationAwareAspectJAutoProxyCreator  ===>internalAutoProxyCreator
 *				
 *				给容器中注册一个 (注解装配模式切面自动代理 自动代理创建器)[注解有意识切面自动代理创建器]AnnotationAwareAspectJAutoProxyCreator
 *				

 *		2、AnnotationAwareAspectJAutoProxyCreator extends AspectJAwareAdvisorAutoProxyCreator
 * 		  AspectJAwareAdvisorAutoProxyCreator extends AbstractAdvisorAutoProxyCreator
 * 		  AbstractAdvisorAutoProxyCreator extends AbstractAutoProxyCreator
 * 		  AbstractAutoProxyCreator extends ProxyProcessorSupport implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware 		
 * 		  -----> ★SmartInstantiationAwareBeanPostProcessor  [beanPostProcessor] =====>bean的后置处理器,关注bean 创建前后
 * 		  -----> ★BeanFactoryAware	 setBeanFactory 
 * 		 AbstractAutoProxyCreator.setBeanFactory();[实现类的方法]
 * 		 AbstractAutoProxyCreator.postProcessBeforeInstantiation()有后置处理器的逻辑[实现类中方法]
 * 			
 * 		 AbstractAdvisorAutoProxyCreator.setBeanFactory() --->initBeanFactory()
 * 		 AnnotationAwareAspectJAutoProxyCreator.initBeanFactory()
 * 		 
 * 
 * 
 * 流程：
 * 		1、传入配置创建ioc容器 
 * 		2、注册配置类，调用refresh(),刷新容器;
 * 				  ==========>//Register bean processors that intercept bean creation.
				  ==========>registerBeanPostProcessors(beanFactory);
		3、PostProcessorRegistrationDelegate.registerBeanPostProcessors(beanFactory); 注册bean的后置处理器方便拦截bean的创建
 * 			1)、    PostProcessorRegistrationDelegate.registerBeanPostProcessors()；
 * 				 先获取ioc容器已经定义的了需要创建的对象的所有的BeanPostProcessor 可以获取到一下后置处理器的信息：
 * 				String[] postProcessorNames = beanFactory.getBeanNamesForType(BeanPostProcessor.class, true, false);
 * 				
 * 				org.springframework.context.annotation.internalAutowiredAnnotationProcessor
				org.springframework.context.annotation.internalRequiredAnnotationProcessor
				org.springframework.context.annotation.internalCommonAnnotationProcessor
				org.springframework.aop.config.internalAutoProxyCreator 
			2)、给容器中加别的BeanPostProcessor
				beanFactory.addBeanPostProcessor(new BeanPostProcessorChecker(beanFactory, beanProcessorTargetCount));
 * 			3)、	优先注册实现了PriorityOrdered接口的BeanProcessor
 * 				对的处理BeanProcessors【// Separate between BeanPostProcessors that implement PriorityOrdered,
						// Ordered, and the rest.】
				// First, register the BeanPostProcessors that implement PriorityOrdered.
				// Next, register the BeanPostProcessors that implement Ordered.
 * 			4)、再给容器中注册 实现了Order接口的BeanProcessor；
 * 			5)、最后给容器注册普通的BeanProccessor  ----->拿BeanProcessor的名字，[BeanPostProcessor pp = beanFactory.getBean(ppName, BeanPostProcessor.class)]然后在
 * 			 ---所谓的注册就是 [org.springframework.aop.config.internalAutoProxyCreator]
 * 			---》这就和前面的EnableAspectJAutoProxy 生成的 internalAutoProxyCreator 产生了关系 
 * 				如果获取不到Bean 就创建 Bean
 * 			6)、注册BeanProcessor，实际上是就是创建BeanProcessor对象，保存在容器中；
 * 				创建internalAutoProxyCreator的BeanProcessor【就是创建AnnotationAwareAspectJAutoProxyCreator对象】
 * 				1)、创建Bean的实例
 * 				2)、populateBean(beanName, mbd, instanceWrapper);给bean的各种属性赋值
 * 				3)、initializeBean 
 * 						1)--->invokeAwareMethods(beanName, bean);处理Aware接口方法的回调
 * 				 		2)--->applyBeanPostProcessorsBeforeInitialization();应用前置处理器的 ProcessorsBeforeInitialization 的方法 ，拿到所有后置处理器(ProcessorsBeforeInitialization)
 * 						3)--->invokeInitMethods(beanName, wrappedBean, mbd); 执行自定义的初始化方法
 * 						4)--->applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);执行后置处理器postProcessAfterInitialization() 
 * 			7)、把BeanPostProcessor注册到BeabFactory
 * 			   beanFactory.addBeanPostProcessor(postProcessor); 
 * 							
 * 4、BeanPostProcessor【AnnotationAwareAspectJAutoProxyCreator】创建成功
 * =========================================以上是创建和注册	AnnotationAwareAspectJAutoProxyCreator的过程======================
 * 
 * 
 * 
 * 
 * 
 * 
 */						

//类是  @EnableAspectJAutoProxy ====  <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
@EnableAspectJAutoProxy
@Configuration
public class MainConfigAOP {
	
	
	
	//业务逻辑	加入容器中
	@Bean
	public MathCalculator mathCalculator ()
	{
		return new MathCalculator ();
	}
	//切面类加入到容器中
	
	@Bean
	public LogAspects log () 
	{
		return new  LogAspects ();
	}
	

}
