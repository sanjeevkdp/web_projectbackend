package com.niit.webproject.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserLoginDao;
import com.niit.model.UserLogin;

public class UserLoginTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
	UserLogin userLogin = (UserLogin) context.getBean("userLogin");
	
	UserLoginDao userLoginDao = (UserLoginDao) context.getBean("userLoginDao");
	     userLogin.setId("002");
	     userLogin.setName("ahmad");
	     userLogin.setAddress("mumbra");
	     userLogin.setContact("9876543212");
	     userLogin.setEmail("ahmad@gmail.com");
	     userLogin.setPassword("122334444");
	     userLogin.setGender("male");

	userLoginDao.saveOrUpdate(userLogin);

	}
}
