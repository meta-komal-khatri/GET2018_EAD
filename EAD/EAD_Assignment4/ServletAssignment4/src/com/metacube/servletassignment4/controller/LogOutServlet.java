package com.metacube.servletassignment4.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		
		HttpSession session=req.getSession();  
        
		session.invalidate();
        
		out.println("<script>alert('Successfully Logged Out!')</script>");
        
		req.getRequestDispatcher("/user_login.html").include(req, resp);
	}

}
