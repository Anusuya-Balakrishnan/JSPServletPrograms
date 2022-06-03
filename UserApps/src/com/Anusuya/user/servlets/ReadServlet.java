package com.Anusuya.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet(urlPatterns="/readServlet")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	Statement stmt;
       
   
	public void init(){
		try {	
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user");
			PrintWriter out = response.getWriter();
			
				out.println("<table>");
				out.println("<tr>");
				out.println("<th> FirstName</th>");
				out.println("<th> LastName</th>");
				out.println("<th> Email</th>");
				out.println("</tr>");
				while(rs.next()){
					out.println("<tr>");
					out.println("<td> "+rs.getString(1)+"</td>");
					out.println("<td> "+rs.getString(2)+"</td>");
					out.println("<td> "+rs.getString(3)+"</td>");
					out.println("</tr>");
			}
				out.println("</table>");
			
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
