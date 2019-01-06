package com.lyp.entiry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class Red  implements ApplicationContextAware,BeanNameAware,EmbeddedValueResolverAware  {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("����ioc: ApplicationContext"+applicationContext);
		this.applicationContext = 	applicationContext;
	}
	
	@Override
	public void setBeanName(String name) {
		
		System.out.println("����Bean�����֣�"+name);
		
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		String resolveStringValue = resolver.resolveStringValue("${os.name} age#{13*2}");
		System.out.println("�������ַ�����ֵ"+resolveStringValue);
	}

}
