package com.metacube.servletassignment4.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.servletassignment4.enums.Status;
import com.metacube.servletassignment4.facade.UserFacade;

public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		
		UserFacade userFacade=UserFacade.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String parameter = req.getParameter("dob");
		
		Date date=null;
		
		try {
			date = new java.sql.Date(sdf.parse(parameter).getTime());
			
			Status status=userFacade.updateUSer(req.getParameter("first_name"), req.getParameter("last_name")
					, date, Integer.parseInt(req.getParameter("mob_no")),req.getParameter("email"));
			if(Status.UPDATED.equals(status)){
			
			 out.println("<script>alert('Successfully Updated')</script>");
			
			}
			
			else{
				
				out.println("<script>alert('Update Failed')</script>");
			}
			
			req.setAttribute("user", req.getParameter("email"));
			
			RequestDispatcher rd=req.getRequestDispatcher("ProfileServlet");  
			
			rd.include(req, resp);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
