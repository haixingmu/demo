package com.yxe.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.ResultSetMetaData;

public class SelectServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = "";
		String sql = "select id, name, age, gender from `user`";
		Connection conn =  MyJdbc.getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet set = ps.executeQuery();
			result = JSON.toJSONString(MyJdbc.convertList(set));
			MyJdbc.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().write(result);
	}
	
}
