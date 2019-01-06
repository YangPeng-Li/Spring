package com.lyp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.lyp.entiry.Person;


//配置类 == 配置文件
@Configuration
@ComponentScan(value="com.componentscan")
public class MainConfig {
		
		//给容器注册一个Bean；类型为返回值类型，id 默认是用方法名作为id 
		@Bean(value="person002")
		public Person person001 ()
		{
			return new Person("Jack吗",12);
		}
		
}
