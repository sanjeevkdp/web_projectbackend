package com.niit.dao;

import java.util.List;
import com.niit.model.Category;

public interface CategoryDao {
	void saveOrUpdate(Category category);

	void delete(String id);

	Category get(String id);

	public List<Category> list();

}