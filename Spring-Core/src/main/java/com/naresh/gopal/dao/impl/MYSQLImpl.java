package com.naresh.gopal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.naresh.gopal.dao.UserDAO;
import com.naresh.gopal.entity.User;

public class MYSQLImpl implements UserDAO {
	
	private Connection con;

	@Override
	public String saveUser(User user) throws SQLException {
		//DriverManager.get
		System.out.println("MYSQL Save User");
		PreparedStatement ps = con.prepareStatement("insert into user values(?,?)");
		ps.setString(1, user.getName());
		ps.setString(2, user.getPwd());
		int count = ps.executeUpdate();
		if(count != 0) return "Saved Succcess";
		return null;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	

}
