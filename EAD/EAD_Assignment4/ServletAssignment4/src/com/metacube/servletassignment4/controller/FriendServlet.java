package com.metacube.servletassignment4.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import com.metacube.servletassignment4.entity.User;
import com.metacube.servletassignment4.facade.UserFacade;

public class FriendServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session=req.getSession();

		PrintWriter out=resp.getWriter();

		UserFacade userFacade=UserFacade.getInstance();	

		String email=(String) session.getAttribute("user");

		User user=userFacade.userName(email);

		List<User> userList=userFacade.getUserByOrganization(user.getOrganization(),user.getEmail());

		out.println("<html>"

				+ "<body>"

				+"<table border=1 font='italic'>");

		if(userList.size()==0){
			out.println("No Friends ");
		}

		else{

			for(User user1:userList){

				out.println("<tr>");


				out.println("<td>"+user1.getFirstName()+"</td>");

				out.println("<td>"+user1.getLastName()+"</td>");

				out.println("<td>"+user1.getDateOfBirth()+"</td>");

				out.println("<td>"+user1.getMobileNumber()+"</td>");

				out.println("<td><input type='text' name='email' value="+user1.getEmail()+"></td>");

				out.println("<td>"
						+ "<a href='ProfileServlet?email="+user1.getEmail()+"'>View</a></td>");

				out.println("</tr>");

			}
		}
		out.println("</table></body></html>");
	}
}
