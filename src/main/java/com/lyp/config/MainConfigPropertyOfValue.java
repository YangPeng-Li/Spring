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
 * ������ ��ͬ�������ļ�
 */

/*
 * ʹ��properties ��ȡ�ⲿ�����ļ��� k/v ���浽���еĻ���������,��Ĭ����value ,��ȡ�����ļ������Ƕ�� �����飩��
 * classpath �� PСд	
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
