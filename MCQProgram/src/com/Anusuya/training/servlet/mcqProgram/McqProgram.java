package com.Anusuya.training.servlet.mcqProgram;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class McqProgram
 */
@WebServlet("/McqProgram")
public class McqProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	Statement stmt;
    
	public void init(ServletConfig config){
		try {	
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/mcq","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from javaquestions");
			PrintWriter out = response.getWriter();
			out.println("<H1>Java Questions</H1>");
			while(rs.next()){
				out.println("<form method=\"post\" action =\"answerServlet\">");
				out.println("<h2>"+rs.getString("questions")+"</h2>");
				out.println("<input type=\"radio\" name=\"answer\" value=\""+ rs.getString("option1") +"\"><label> "+rs.getString("option1")+"</label><br>");
				out.println("<input type=\"radio\" name=\"answer\" value=\""+ rs.getString("option2") +"\"> "+rs.getString("option2")+"</label><br>");
				out.println("<input type=\"radio\" name=\"answer\"value=\""+ rs.getString("option2") +"\">"+rs.getString("option3")+"</label><br>");
				out.println("</form >");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	public void destroy(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
