package com.lyp;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lyp.AOP.MathCalculator;
import com.lyp.config.MainConfigAOP;

public class MainTestAOP {

	@Test
	public void test_AOP() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				MainConfigAOP.class);
		
		//不要自己创建对象	
		//MathCalculator mathCalculator = new MathCalculator ();
		MathCalculator bean = applicationContext.getBean(MathCalculator.class);
		bean.div(9, 2);
		}

}
