package com.lyp.entiry;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@Component
public class Cat implements InitializingBean, DisposableBean {

	public Cat ()
	{
		System.out.println("Ã¨µÄ Construct ....");
	}
	
	
	@Override
	public void destroy() throws Exception {
		
		System.out.println("Ã¨µÄDestroy .... ");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Ã¨µÄ afterPropertiesSet .... ");
	}
	private String name;
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
