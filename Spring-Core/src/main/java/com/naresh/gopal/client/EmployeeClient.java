package com.naresh.gopal.client;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.naresh.gopal.core.Company;
import com.naresh.gopal.core.Employee;
import com.naresh.gopal.entity.User;
import com.naresh.gopal.service.Service;

public class EmployeeClient {

	public static void main(String[] args) throws SQLException {

		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory bf = new XmlBeanFactory(resource);
		Service ser = (Service) bf.getBean("service");
		User user = new User();
		user.setName("gopal123");
		user.setPwd("gopal123");
		String msg = ser.saveUser(user);
		System.out.println(msg);
	}

}
