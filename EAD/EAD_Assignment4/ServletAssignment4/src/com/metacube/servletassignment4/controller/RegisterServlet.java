package com.metacube.servletassignment4.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.servletassignment4.entity.User;
import com.metacube.servletassignment4.enums.Status;
import com.metacube.servletassignment4.facade.UserFacade;

public class RegisterServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserFacade userFacade=UserFacade.getInstance();
		
		
		PrintWriter out=resp.getWriter();
		
		File file=new File("C:\\Users\\User30\\Desktop\\download.png");
		InputStream image = new FileInputStream(file);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String parameter = req.getParameter("dob");
		Date date=null;
		
		String email=req.getParameter("email");
		try {
		
			date = new java.sql.Date(sdf.parse(parameter).getTime());
	
			User user=new User(req.getParameter("first_name"),req.getParameter("last_name"),Integer.parseInt(req.getParameter("age"))
					,date,Integer.parseInt(req.getParameter("mobile_number")),req.getParameter("password"),req.getParameter("email")
					,req.getParameter("organization"),image);
			Status status =userFacade.registerUser(user);
			if(Status.CREATED.equals(status)){
				out.print("<script>alert('User Created')</script>");  
				
				HttpSession session=req.getSession();
				session.setAttribute("user", email);
				resp.sendRedirect("/ProfileServlet");
				/*RequestDispatcher rd=req.getRequestDispatcher("/LogInServlet");  
				rd.include(req, resp);*/ 
			}
			else{
				out.print("<script>alert('User already exist')</script>");  
				RequestDispatcher rd=req.getRequestDispatcher("/user_registration.html");  
				rd.include(req, resp); 
			}
			
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		catch (ParseException e) {
		
		e.printStackTrace();
		}
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
