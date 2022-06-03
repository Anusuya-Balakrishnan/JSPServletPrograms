package com.Anusuya.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;  
	Statement stmt;
    
	   
	public void init(){
		try {	
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		try {
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate("delete from user where email='"+email+"'");
			PrintWriter out = response.getWriter();
			if(result>0){
				out.println("user data deleted");
			}
			else{
				out.println("Error when deleting user data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void destroy(){
		try {
			stmt.close();
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
