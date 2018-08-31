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

import com.metacube.servletassignment4.entity.User;
import com.metacube.servletassignment4.enums.Status;
import com.metacube.servletassignment4.facade.UserFacade;

public class RegisterServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserFacade userFacade=UserFacade.getInstance();
		PrintWriter out=resp.getWriter();
		File file=new File(".\\ServletAssignment4\\WebContent\\images\\DefaultProfilePicture.png");
		InputStream image = new FileInputStream(file);
		try {
			User user=new User(req.getParameter("first_name"),req.getParameter("last_name"),Integer.parseInt(req.getParameter("age"))
					,(Date) new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("dob")),Integer.parseInt(req.getParameter("mobile_number")),req.getParameter("passwor"),req.getParameter("email")
					,req.getParameter("organization"),image);
			Status status =userFacade.registerUser(user);
			if(Status.DUPLICATED.equals(status)){
				out.print("<script>alert('User already exist')</script>");  
				RequestDispatcher rd=req.getRequestDispatcher("/user_registration.html");  
				rd.include(req, resp); 
			}
			
		} catch (NumberFormatException | ParseException e) {
			e.printStackTrace();
		}
		
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
