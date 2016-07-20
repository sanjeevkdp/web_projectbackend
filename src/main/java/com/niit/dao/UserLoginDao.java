package com.niit.dao;

import java.util.List;

import com.niit.model.UserLogin;

public interface UserLoginDao {
	void saveOrUpdate(UserLogin userLogin);

	void delete(String id);

	UserLogin get(String id);

	public List<UserLogin> list();
	
}
