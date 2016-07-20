package com.niit.webproject.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDao;
import com.niit.model.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		Supplier supplier = (Supplier) context.getBean("supplier");

		SupplierDao supplierDao = (SupplierDao) context.getBean("supplierDao");
		supplier.setId("21");
		supplier.setName("parul");
		supplier.setContact("9123456780");
		supplier.setAddress("thane");
		supplier.setEmail("parul@gmail.com");
		supplier.setImgUrl("default.jpeg");
		

		supplierDao.saveOrUpdate(supplier);

	}

}
