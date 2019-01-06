package com.lyp.entiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 *  默认添加在IOC 容器中的组件，容器会调用无参构造器创建对象，进行初始化赋值等操作 	
 * @author lyp	
 *
 */

@Component
public class Boss {
	private String name;
	
	private Car  car;
	
	public String getName() {
		return name;
	}
	@Value("Boss")
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	//标注在方法上，Spring 容器创建当前对象，就会调用方法，完成赋值
	//方法使用的参数，自定义类型的值从ioc容器中取
	@Autowired 
	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "Boss [name=" + name + ", car=" + car + "]";
	}
	@Autowired
	public Boss(Car car) {
		this.car=car;
		System.out.println("Boss .....的有参构造器");
				
	}
	
	
}
