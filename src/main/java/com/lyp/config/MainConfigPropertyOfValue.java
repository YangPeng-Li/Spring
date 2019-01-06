package com.lyp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.lyp.entiry.Boss;
import com.lyp.entiry.Car;
import com.lyp.entiry.Color;
import com.lyp.entiry.Person;

/*
 * 配置类 等同于配置文件
 */

/*
 * 使用properties 读取外部配置文件的 k/v 保存到运行的环境变量中,【默认是value ,读取配置文件可以是多个 （数组）】
 * classpath 需 P小写	
 */

@PropertySource(value={"classpath:/person.properties"})
@Configuration
@ComponentScan("com.lyp.entiry")
public class MainConfigPropertyOfValue {

	@Bean
	public Person person()
	{
		return new  Person ();
	}
	
	@Bean 
	public Boss boss ()
	{
		return new Boss(null);
	}
	
	@Bean
	public Color color (Car car)
	{
		Color color = new  Color();
		color.setCar(car);
		
		return new Color();
	}
	
}
