package com.Anusuya.training.servlets.jdbc.preparedStatement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement stmt;

	public void init() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
			stmt=con.prepareStatement("insert into product values(?,?,?,?)");

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException  e) {
			e.printStackTrace();
		} 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		int price=Integer.parseInt(request.getParameter("price"));
		try {
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, description);
			stmt.setInt(4, price);
			
			
			int result = stmt.executeUpdate();
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<b>"+result +" product created</b>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void destroy() {
	
		try {
			con.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
