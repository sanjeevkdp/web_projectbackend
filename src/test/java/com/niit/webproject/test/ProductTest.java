package com.niit.webproject.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDao;
import com.niit.model.Product;

public class ProductTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
	Product product = (Product) context.getBean("product");
	
	ProductDao productDao = (ProductDao) context.getBean("productDao");
	    product.setId("002");
		product.setName("MI");
		product.setPrice(677898);
		product.setQuantity(30);
		product.setImgUrl("default.jpeg");

		productDao.saveOrUpdate(product);

}
}
