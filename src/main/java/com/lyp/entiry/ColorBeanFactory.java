package com.lyp.entiry;

import org.springframework.beans.factory.FactoryBean;

public class ColorBeanFactory implements FactoryBean<Color> {
	//返回一个Color对象，这个对象会添加到容器中
	@Override
	public Color getObject() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CollorBeanFactory----Color");
		return new Color();
	}
	//返回类的类型
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}
	//是否单实例？ true 是单实例
	
	@Override
	public boolean isSingleton() {
		
		return true;
	}


}
