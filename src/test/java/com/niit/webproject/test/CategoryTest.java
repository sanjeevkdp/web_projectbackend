package com.niit.webproject.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

public class CategoryTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
	Category category = (Category) context.getBean("category");
	
	CategoryDao categoryDao = (CategoryDao) context.getBean("categoryDao");
		category.setId("002");
		category.setName("redmenote");
		category.setBrand("MI");

		categoryDao.saveOrUpdate(category);

	}
}
