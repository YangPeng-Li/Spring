package com.lyp;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.componentscan.dao.BookDao;
import com.componentscan.service.BookService;
import com.lyp.config.MainConfigAutowired;

public class MainTestAutowired {
	
	@Test
	public void test_Autowired()
	{
		 AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigAutowired.class);
		 
		 
	
		  BookService bookService = (BookService) applicationContext.getBean(BookService.class);
		  System.out.println(bookService);
		 
		  
		/*  BookDao bookDao = (BookDao) applicationContext.getBean(BookDao.class);
		  System.out.println(bookDao);*/
		 
		
		  applicationContext.close();
	}

	
}
