package com.lyp.AOP;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class LogAspects {

	/**
	 * ��ȡ�����������ʽ��
	 * 1������
	 * 2��������
	 * 
	 */
	@Pointcut("execution(public double com.lyp.AOP.MathCalculator.*(..))")
	public void pointCut (){};
	
	//��Ŀ�귽��֮ǰ���룬�е���ʽ��ָ����	�ĸ��������룩
	//@Before("com.lyp.AOP.MathCalculator.*(..)")
	@Before("pointCut()")
	public void logStart (JoinPoint joinPoint)
	{
			Object[] args = joinPoint.getArgs();
			//getSignature().getName()  ǩ�� 
		System.out.println(joinPoint.getSignature().getName()+"��������.......�����б�:{"+Arrays.asList(args)+"}");
	}
	
	@After("com.lyp.AOP.LogAspects.pointCut()")
	public void logEnd () 
	{
		System.out.println("��������.......");
	}
	
	@AfterReturning(value="pointCut()",returning="result")
	public void logReturn (Object result)
	{
		System.out.println("�����������ء������������н��Ϊ��{"+result+"}");
	}
	
	
	//joinPoint ����һ��Ҫд�ڲ����б�ĵ�һλ
	@AfterThrowing(value="pointCut()",throwing="ex")
	public void logException (JoinPoint joinPoint,Exception ex)
	{
		Object[] args = joinPoint.getArgs();
		System.out.println(Arrays.asList(args)+"�����쳣�����������쳣��Ϣ��{"+ex+"}");
	}
	
}
