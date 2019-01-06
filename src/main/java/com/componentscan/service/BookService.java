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
	 * Ĭ��  ����  ��������ȥ�����в������ applicationContext.getBean()
	 * 
	 */
	
	//@Qualifier("bookDao2")//��ȷָ��Ҫ���Ǹ� ��Queer�� �������� ,Qualifier ָ���Զ�װ��bean��ֵ ��bookDao1 ��bookDao2 ����ȥ�ã�
	//@Autowired(required=false) //Autowired required����Ĭ����true �������о�װ��û�оͲ�װ����װ��װ��װ��������
	
	//@Resource(name="bookDao")
	
	@Inject
	private BookDao bookDao;
	
	public void print ()
	{
		System.out.println("Service DAO ����"+bookDao);
	}

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}
	
}
