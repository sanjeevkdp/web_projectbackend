package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDao {
	void saveOrUpdate(Supplier supplier);

	void delete(String id);

	Supplier get(String id);

	public List<Supplier> list();
	
}
