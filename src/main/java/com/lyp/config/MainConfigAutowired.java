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
 *�Զ�װ�� ��
 *		Spring  ��������ע�루DI�� ,��ɶ�IOC�����и��������������ϵ��ֵ
 *
 * 1)@Autowired �� �Զ�ע��
 * 		1)��Ĭ�ϰ�������ȥ�������Ҷ�Ӧ�������applicationContext.getBean ()
 * 		2)������ҵ������ͬ����������ٽ����Ե�������Ϊ�����idȥ�����в���
 * 				application.getBean("bookDao")
 * 		3)��Qualifier("bookDao"):ʹ��@Qualifer��Ҫָ����Ҫװ�������id,���������Ե���
 * 		4)���Զ�װ��һ��Ҫ�����Ը�ֵ�ã�û�оͻᱨ�� 
 * 			@Autowired(required=false)
 * 		5)��@Primary:��Spring �����Զ�װ���ʱ��Ĭ��ʹ����ѡ��bean ָ���ġ���ĸ֮����������װ�������С�
 * 			Ҳ���Լ���ʹ��@Qualifierָ����Ҫװ���bean������
 * 
 * 			BookService {
 * 			@Autowired 
 * 			BookDao  bookDao;
 * 			}
 *2) Spring ��֧��@Resource(JSR250) ��@Inject(JSR330) [JAVA �淶��ע��-��Ҫ��Maven����� javax-inject]
 *				@Resource :
	 *				���Ժ�@Autowired һ��ʵ���Զ�װ�书�ܣ�Ĭ���ǰ�ס��������ƽ���װ���
	 *				û����֧��@Primary�����ظ� @Autowired ��required=false��
 *				@Inject:
 *	 					��Maven����� javax-inject]��Autowired�Ĺ���һ��
 * 				@Autowired:Spring����� ;   ��@Resource��@Inject����Java�淶
 * 
 *  AutowiredAnnotationBeanPostProcessor����������Զ�װ�书��
 * 3) Autowired �������������������������� ���Ǵ������л�ȡ���������ֵ
 * 				���ڹ���������
 * 				������@Bean+ ���������������������л�ȡ��Ĭ�ϲ�д@Autowired Ч��һ���������Զ�ע�뵽������
 *				������������ֻ��һ�� �вι�����������вι�������@Autowired ����ʡ��
 * 				����
 * 
 * 4)��	 	�Զ����齨��Ҫʹ��Spring �ײ��һЩ�����ApplicationContext��BeanFactory���ȣ���
 * 	     	�Զ������ʵ��xxxAware���ڴ��������ʱ�򣬻ص��ýӿڹ涨�ķ�����������Aware
 * 			��Spring�ײ�һЩ���ע�뵽�Զ����Bean�У�
 * 			XXXAware �������ظ�ʹ��xxxProcessor
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
