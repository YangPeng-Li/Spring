package com.lyp;


import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lyp.config.MainConfigProfile;

public class MainTestProfile {

	/**
	 * @Profile 启动激活方法：
	 * 					 ① 在VM argument Dspring.profiles.active=test
	 * 					 ② 使用代码	完成对不同环境的启动
	 */
	

	@Test
	public void test_ProfileDataSource() 
	{
		 AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		//2.设置需要激活的环境
		applicationContext.getEnvironment().setActiveProfiles("test","prod");
		//3.注册主配置类
		applicationContext.register(MainConfigProfile.class);
		//4.启动刷新
		applicationContext.refresh();
		String[] nameFcty = applicationContext.getBeanNamesForType(DataSource.class);
		for (String names : nameFcty) {
			System.out.println(names);
		}
	}

}
