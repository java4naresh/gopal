package com.naresh.gopal.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class MyFilter
 */
public class MyFilter implements Filter {
	
	private Connection con;

    /**
     * Default constructor. 
     */
    public MyFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String host = request.getRemoteHost();
		/*if("0:0:0:0:0:0:0:1".equals(host)) {
			throw new RuntimeException("Host is Not allowed");
		}*/
		
		/*String strNumber = request.getParameter("number");
		int number = Integer.parseInt(strNumber);
		if(number < 0) throw new RuntimeException("Negitive number is Not allowed");*/
		
		/*String gmail = request.getParameter("gmail");
		if(gmail != null && !"".equals(gmail) && !gmail.contains("@gmail.com")) {
			gmail = gmail+"@gmail.com";
		}
		request.setAttribute("gmail", gmail);*/
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		if(con != null && userName != null && !"".equals(userName)) {
			String query = "select pwd from user where name = "+"'"+userName+"'";
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				String actualPassword = null;
				while(rs.next()) {
					actualPassword = rs.getString("pwd");
				}
				
				if(password != null && actualPassword != null && actualPassword.equals(password)) {
					chain.doFilter(request, response);
				} else if(actualPassword == null) {
					response.getWriter().append("<p style='color:red'>User Name Does not exist</p>");
				} else if(!actualPassword.equals(password)) {
					response.getWriter().append("<p style='color:red'>Password Wrong</p>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if("".equals(userName)) {
			response.getWriter().append("<p style='color:red'>Please enteruser name and password</p>");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gopal", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
