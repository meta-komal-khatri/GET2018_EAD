package com.metacube.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.dao.EmployeeDao;
import com.metacube.pojo.Employee;

@SuppressWarnings("serial")
public class Update extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EmployeeDao employeeDao=new EmployeeDao();
		PrintWriter out=resp.getWriter();
		String email=req.getParameter("email");
		try{
		Employee employee=employeeDao.selectEmployeeByEmailId(email);
		
		out.println("<html>"
				      +"<body>"
				      	+"<form action='UpdateEmployeeDetails' method='get'>"
				      	  +"<table>"
							+"<tr>"
				      	  	  +"<td>First Name</td>"
				      	  	  +"<td><input type='text' name='first_name' value='"+employee.getFirstName()+"'></td>"
				      	  	+"</tr>"
					      	+"<tr>"
				      	  	  +"<td>Last Name</td>"
				      	  	  +"<td><input type='text' name='last_name' value='"+employee.getLastName()+"'></td>"
				      	  	+"</tr>"
				      	  	+"<tr>"
				      	  	  +"<td>email</td>"
				      	  	  +"<td><input type='text' name='email' value='"+employee.getEmail()+"'readonly></td>"
				      	  	+"</tr>"
				      	  	+"<tr>"
				      	  	  +"<td>age</td>"
			      	  	      +"<td><input type='text' name='age' value='"+employee.getAge()+"'></td>"
			      	  	    +"</tr>"
			      	  	    +"<tr>"
			      	  	      +"<td colspan='2'><input type='submit' value='Update'></td>"
			      	  	    +"</tr>"
			      	  	  +"</table>"
			      	  	 +"</form>"
			      	  	+"<body>"
			      	  +"</html>");
		}catch(AssertionError e){
			out.println("<script>alert('no such employee available')</script>");
			RequestDispatcher rd=req.getRequestDispatcher("Update");  
			rd.include(req, resp);
		}
		
	}
}
