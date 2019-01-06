package com.componentscan.service;

import static org.junit.Assert.assertFalse;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.componentscan.dao.BookDao;

@Service
public class BookService {

	
	/**
	 * 默认  优先  按照类型去容器中查找组件 applicationContext.getBean()
	 * 
	 */
	
	//@Qualifier("bookDao2")//明确指定要点那个 （Queer） 进入容器 ,Qualifier 指定自动装配bean的值 （bookDao1 和bookDao2 任意去用）
	//@Autowired(required=false) //Autowired required属性默认是true 容器中有就装，没有就不装，爱装不装，装不上拉到
	
	//@Resource(name="bookDao")
	
	@Inject
	private BookDao bookDao;
	
	public void print ()
	{
		System.out.println("Service DAO 对象"+bookDao);
	}

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}
	
}
