package com.lyp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.lyp.entiry.Person;


//������ == �����ļ�
@Configuration
@ComponentScan(value="com.componentscan")
public class MainConfig {
		
		//������ע��һ��Bean������Ϊ����ֵ���ͣ�id Ĭ�����÷�������Ϊid 
		@Bean(value="person002")
		public Person person001 ()
		{
			return new Person("Jack��",12);
		}
		
}
