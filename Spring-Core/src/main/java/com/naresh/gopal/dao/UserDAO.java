package com.naresh.gopal.dao;

import java.sql.SQLException;

import com.naresh.gopal.entity.User;

public interface UserDAO {
	
	public String saveUser(User user) throws SQLException;

}
