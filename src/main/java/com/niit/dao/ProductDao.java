package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDao {
	void saveOrUpdate(Product product);

	void delete(String id);

	Product get(String id);

	public List<Product> list();
	

}
