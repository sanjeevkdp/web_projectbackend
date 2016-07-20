package com.niit.Dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;

public interface CategoryDao {
	void saveOrUpdate(Category category);

	void delete(String cid);

	Category get(String cid);

	public List<Category> list();

}