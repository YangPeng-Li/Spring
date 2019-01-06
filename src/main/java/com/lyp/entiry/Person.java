package com.lyp.entiry;

import org.springframework.beans.factory.annotation.Value;


public class Person {
	
	
	/*
	 *使用@Value赋值
	 *1、基本数值
	 *2、可以使用SpEl,#{}
	 *3、可以写 ${}: 取出配置文件中【properties】中的值（在运行环境变量的值） 
	 */
	
	@Value("lyp")
	private String name;
	@Value("#{29-2}")
	private Integer age;
	
	@Value("${person.nickName}")
	private String NickName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", NickName=" + NickName + "]";
	}
	public Person() {
		super();
	}
	
}
