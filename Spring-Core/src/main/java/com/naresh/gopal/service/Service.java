package com.naresh.gopal.service;

import java.sql.SQLException;

import com.naresh.gopal.dao.UserDAO;
import com.naresh.gopal.entity.User;

public class Service {
	
	private UserDAO dao;

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	
	public String saveUser(User user) throws SQLException {
		return dao.saveUser(user);
	}

}
