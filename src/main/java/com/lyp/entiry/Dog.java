package com.lyp.entiry;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Dog {
	
	public Dog() 
	{
		System.out.println("Dog Contruct .....");
	}
	
	@PostConstruct
	public void init ()
	{
		System.out.println("Dog ini ....");
	}	
	
	@PreDestroy
	public void destory ()
	{
		System.out.println("Dog Destroy ....");
	}
	

}
