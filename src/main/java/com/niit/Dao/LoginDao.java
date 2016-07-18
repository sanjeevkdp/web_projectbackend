package com.niit.Dao;

import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

	public boolean isValidLogin(String email, String pwd) {

		if (email.equals("sanjeev@gmail.com") && pwd.equals("123456789")) {
			return true;
		}

		else {

			return false;
		}
	}
}
