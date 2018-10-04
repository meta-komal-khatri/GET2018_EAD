package com.metacube.servletassignment4.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.servletassignment4.entity.User;
import com.metacube.servletassignment4.facade.UserFacade;

public class ProfileServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		UserFacade userFacade=UserFacade.getInstance();
		
		PrintWriter out=resp.getWriter();
		
		HttpSession session=req.getSession();
		
		String email=(String) req.getParameter("email");
		
		User user=userFacade.userName(email);
		
		String visibility;
		
		if(session.getAttribute("user").equals(email)){
			
			visibility="visible";
		}
		
		else{
			
			visibility="hidden";
		}
		out.println("<html>"
					+"<head>"
					+ "<script>"
						+ "function enableAll()"
							+ "{"
								+ "enablebyId('txt_firstname');"
								+ "enablebyId('txt_lastname');	"
								+ "enablebyId('txt_dob');"
								+ "enablebyId('txt_mob');"
								+ "enablebyId('btn_save');"
							+ "}"
				
						+ "function enablebyId(id)"
					+ "{"
						+ " document.getElementById(id).disabled = false;"
					+ "}"
					+ "</script>"
					+ "</head>"
					  +"<body>"
					  + "<form action='UpdateServlet' method='get'>"
					  +"<table width='100%'>"
					  +"<tr><td><a href='FriendServlet?'>Friends</a></td><td align='left'><img src='./images/DefaultProfilePicture.png'></td><td align='right' width='30px'>"+user.getFirstName()+"|"
					  		+ "<a href='LogOutServlet'>LogOut</a></td></tr></table>"
					  
						+"<table align='center'>"
						+"<tr>"
				   	  	+ "<td>Email</td>"
				   	  	+ "<td><input type='text' id='txt_eamil' name='email' value='"+user.getEmail()+"'readonly></td>"
				   	  + "</tr>"
					   	  +"<tr>"
					   	  	+ "<td>First Name</td>"
					   	  	+ "<td><input type='text' id='txt_firstname' name='first_name' value='"+user.getFirstName()+"'disabled='true'></td>"
					   	  + "</tr>"
					   	  +"<tr>"
					   	  	+ "<td>Last Name</td>"
					   	  	+ "<td><input type='text' id='txt_lastname' name='last_name' value='"+user.getLastName()+"'disabled='true'></td>"
					   	  + "</tr>"
					   	  +"<tr>"
					   	  	+ "<td>Date of Birth</td>"
					   	  	+ "<td><input type='date' id='txt_dob' name='dob' value='"+user.getDateOfBirth()+"'disabled='true'></td>"
					   	  + "</tr>"
					   	  +"<tr>"
					   	  	+ "<td>Mobile number</td>"
					   	  	+ "<td><input type='text' id='txt_mob' name='mob_no' value='"+user.getMobileNumber()+"'disabled='true'></td>"
					   	  + "</tr>"
					   	  +"<tr>"
					   	  	+ "<td><input type='button' value='Edit' name='btn_edit' onclick='enableAll()' style='visibility:" + visibility + "'></td>"
					   	  	+ "<td><input type='submit' value='Save' name='btn_save' id='btn_save' disabled='true' style='visibility:" + visibility +"'></td>"
					   	  +"</tr>"
						+"</table>"
					   +"</form>"
					  +"</body>"
					 +"</html>");
		
		
	}
}
