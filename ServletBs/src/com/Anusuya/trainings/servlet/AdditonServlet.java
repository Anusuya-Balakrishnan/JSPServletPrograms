package com.Anusuya.trainings.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AdditonServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		if(request.getParameter("number1")!=null && request.getParameter("number2")!=null){
			Long num1 = Long.parseLong(request.getParameter("number1"));
		      Long num2 = Long.parseLong(request.getParameter("number2"));
		      PrintWriter out = response.getWriter();
		      out.println("The Result is "+(num1+num2));
		      
		      
		      
		}
      
	}

}
