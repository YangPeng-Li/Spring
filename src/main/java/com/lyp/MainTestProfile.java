package com.lyp;


import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lyp.config.MainConfigProfile;

public class MainTestProfile {

	/**
	 * @Profile �����������
	 * 					 �� ��VM argument Dspring.profiles.active=test
	 * 					 �� ʹ�ô���	��ɶԲ�ͬ����������
	 */
	

	@Test
	public void test_ProfileDataSource() 
	{
		 AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		//2.������Ҫ����Ļ���
		applicationContext.getEnvironment().setActiveProfiles("test","prod");
		//3.ע����������
		applicationContext.register(MainConfigProfile.class);
		//4.����ˢ��
		applicationContext.refresh();
		String[] nameFcty = applicationContext.getBeanNamesForType(DataSource.class);
		for (String names : nameFcty) {
			System.out.println(names);
		}
	}

}
