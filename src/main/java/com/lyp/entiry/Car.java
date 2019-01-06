package com.lyp.entiry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * �˷����Ƕ�Bean ���������ڽ��в��� ��
 * @author Lyp
 *
 */
@Component
public class Car {
	
	public Car  ()
	{
		System.out.println("Car Constructor .....");
	}
	
	public void init ()
	{
		System.out.println("Car init .....");
	}
	
	public void destory ()
	{
		System.out.println("Car destory");
	}
	
	private String name;
	public String getName() {
		return name;
	}
	@Value("VloksWagen Passte ")
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + "]";
	}
	
}	
