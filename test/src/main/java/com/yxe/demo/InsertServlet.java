package com.yxe.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = "";
		if (null == req.getParameter("name")) {
			result = "name is not null";
			resp.getWriter().write(result);
			return ;
		}
		if (null == req.getParameter("age")) {
			result = "必要参数age不能为空！！！";
			resp.getWriter().write(result);
			return ;
		}
		if (null == req.getParameter("gender")) {
			result = "必要参数gender不能为空！！！";
			resp.getWriter().write(result);
			return ;
		}
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		
		
		String sql = "insert into `user`(name, age, gender) values(?,?,?) ";
		Connection conn =  MyJdbc.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, gender);
			ps.executeUpdate();
			MyJdbc.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
