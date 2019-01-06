package com.lyp.entiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 *  Ĭ�������IOC �����е����������������޲ι������������󣬽��г�ʼ����ֵ�Ȳ��� 	
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
	//��ע�ڷ����ϣ�Spring ����������ǰ���󣬾ͻ���÷�������ɸ�ֵ
	//����ʹ�õĲ������Զ������͵�ֵ��ioc������ȡ
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
		System.out.println("Boss .....���вι�����");
				
	}
	
	
}
