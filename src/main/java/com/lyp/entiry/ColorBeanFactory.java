package com.lyp.entiry;

import org.springframework.beans.factory.FactoryBean;

public class ColorBeanFactory implements FactoryBean<Color> {
	//����һ��Color��������������ӵ�������
	@Override
	public Color getObject() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CollorBeanFactory----Color");
		return new Color();
	}
	//�����������
	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Color.class;
	}
	//�Ƿ�ʵ���� true �ǵ�ʵ��
	
	@Override
	public boolean isSingleton() {
		
		return true;
	}


}
