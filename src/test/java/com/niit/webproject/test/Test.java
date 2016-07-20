package com.niit.webproject.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.CategoryDao;
import com.niit.model.Category;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
	Category category = (Category) context.getBean("category");
	
	CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDao");
		category.setCId("002");
		category.setCName("ahmad");

		categoryDao.saveOrUpdate(category);

	}
}
