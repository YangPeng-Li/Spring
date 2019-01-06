package com.lyp.entiry;

import org.springframework.beans.factory.annotation.Value;


public class Person {
	
	
	/*
	 *ʹ��@Value��ֵ
	 *1��������ֵ
	 *2������ʹ��SpEl,#{}
	 *3������д ${}: ȡ�������ļ��С�properties���е�ֵ�������л���������ֵ�� 
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
