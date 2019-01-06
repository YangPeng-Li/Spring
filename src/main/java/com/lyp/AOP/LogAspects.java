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
	 * 抽取公共切入点表达式：
	 * 1、本类
	 * 2、其他类
	 * 
	 */
	@Pointcut("execution(public double com.lyp.AOP.MathCalculator.*(..))")
	public void pointCut (){};
	
	//在目标方法之前切入，切点表达式（指定在	哪个方法切入）
	//@Before("com.lyp.AOP.MathCalculator.*(..)")
	@Before("pointCut()")
	public void logStart (JoinPoint joinPoint)
	{
			Object[] args = joinPoint.getArgs();
			//getSignature().getName()  签名 
		System.out.println(joinPoint.getSignature().getName()+"除法运行.......参数列表:{"+Arrays.asList(args)+"}");
	}
	
	@After("com.lyp.AOP.LogAspects.pointCut()")
	public void logEnd () 
	{
		System.out.println("除法结束.......");
	}
	
	@AfterReturning(value="pointCut()",returning="result")
	public void logReturn (Object result)
	{
		System.out.println("除法正常返回。。。。。运行结果为：{"+result+"}");
	}
	
	
	//joinPoint 参数一定要写在参数列表的第一位
	@AfterThrowing(value="pointCut()",throwing="ex")
	public void logException (JoinPoint joinPoint,Exception ex)
	{
		Object[] args = joinPoint.getArgs();
		System.out.println(Arrays.asList(args)+"除法异常。。。。。异常信息：{"+ex+"}");
	}
	
}
