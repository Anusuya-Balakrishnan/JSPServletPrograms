package com.Anusuya.training.servlet.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/filterServlet")
public class DemoFilter implements Filter {

    
	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("Pre servlet");
		chain.doFilter(request, response);
		out.println("Post servlet");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
