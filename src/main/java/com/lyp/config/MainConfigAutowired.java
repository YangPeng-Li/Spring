package com.lyp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.componentscan.controller.BookController;
import com.componentscan.dao.BookDao;
import com.componentscan.service.BookService;

/**AutoWired 
 * 
 *自动装配 ；
 *		Spring  利用依赖注入（DI） ,完成对IOC容器中各个组件的依赖关系赋值
 *
 * 1)@Autowired ： 自动注入
 * 		1)、默认按照类型去容器中找对应的组件：applicationContext.getBean ()
 * 		2)、如果找到多个相同类型组件，再将属性的名称作为组件的id去容器中查找
 * 				application.getBean("bookDao")
 * 		3)、Qualifier("bookDao"):使用@Qualifer需要指定需要装配组件的id,而不是属性的名
 * 		4)、自动装配一定要将属性赋值好，没有就会报错 
 * 			@Autowired(required=false)
 * 		5)、@Primary:让Spring 进行自动装配的时候，默认使用首选的bean 指定的【父母之命必须用它装载容器中】
 * 			也可以继续使用@Qualifier指定需要装配的bean的名字
 * 
 * 			BookService {
 * 			@Autowired 
 * 			BookDao  bookDao;
 * 			}
 *2) Spring 还支持@Resource(JSR250) 和@Inject(JSR330) [JAVA 规范的注解-需要在Maven中添加 javax-inject]
 *				@Resource :
	 *				可以和@Autowired 一样实现自动装配功能，默认是按住组件的名称进行装配的
	 *				没有能支持@Primary功能呢个 @Autowired （required=false）
 *				@Inject:
 *	 					在Maven中添加 javax-inject]和Autowired的功能一样
 * 				@Autowired:Spring定义的 ;   而@Resource、@Inject都是Java规范
 * 
 *  AutowiredAnnotationBeanPostProcessor：解析完成自动装配功能
 * 3) Autowired ：构造器、方法、参数、属性 都是从容器中获取参数组件的值
 * 				【在构造器】，
 * 				方法，@Bean+ 方法参数，参数从容器中获取，默认不写@Autowired 效果一样，都能自动注入到容器中
 *				参数，如果组件只有一个 有参构造器，这个有参构造器的@Autowired 可以省略
 * 				属性
 * 
 * 4)、	 	自定义组建想要使用Spring 底层的一些组件（ApplicationContext、BeanFactory、等）；
 * 	     	自定义组件实现xxxAware，在创建对象的时候，回调用接口规定的方法相关组件，Aware
 * 			把Spring底层一些组件注入到自定义的Bean中；
 * 			XXXAware ：功能呢个使用xxxProcessor
 * 					ApplicationContextAware ===>ApplicationContextAwareProcessor
 * 			
 */

@Configuration
@ComponentScan({"com.componentscan.controller","com.componentscan.dao","com.componentscan.service"})
public class MainConfigAutowired {
	
	
	@Primary
	@Bean("bookDao2")
	public  BookDao bookDao() {
		
		BookDao bookDao2 = new BookDao();
		bookDao2.setLable("2");
		return bookDao2;
	}
	
}
