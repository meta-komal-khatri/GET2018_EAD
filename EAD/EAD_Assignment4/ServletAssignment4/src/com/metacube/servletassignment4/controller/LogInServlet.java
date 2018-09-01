package com.metacube.servletassignment4.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;

import com.metacube.servletassignment4.entity.User;
import com.metacube.servletassignment4.enums.Status;
import com.metacube.servletassignment4.facade.UserFacade;

@SuppressWarnings("serial")
public class LogInServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		UserFacade userFacade=UserFacade.getInstance();
		
		PrintWriter out=resp.getWriter();
		
		String email=req.getParameter("email");
		
		String password=req.getParameter("password");
		
		Status status=userFacade.logInUser(email, password);
		
		if(Status.SUCCESS.equals(status)){
			
			HttpSession session=req.getSession(true);
			
			session.setAttribute("user", email);
			
			req.setAttribute("user",email );
			
			
			/*byte[] image=user.getImage();
			Base64 codec = new Base64();
			String encoded = Base64.encodeBase64String(image);
			req.setAttribute("image",encoded);
			*/
			
			
			RequestDispatcher rd=req.getRequestDispatcher("/ProfileServlet");  
			
			rd.include(req, resp); 
			 
		}
		else{
			out.println("<script>alert('User already exist')</script>");  
			
			RequestDispatcher rd=req.getRequestDispatcher("/user_login.html");  
			
			rd.include(req, resp); 
		}
		
		
		
	
		
		
	}
}
