package com.lyp.AOP;


/**
 * 
 * 
 *	@author Lyp
 * 2018年11月27日
 * 下午8:23:00
 */

public class MathCalculator {

	public double div (double i,double j)
	{
		System.out.println("此处写日志具有耦合性");
		return i/j;
	}
}
