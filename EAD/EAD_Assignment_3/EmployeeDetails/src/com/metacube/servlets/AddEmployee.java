package com.metacube.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.metacube.pojo.Employee;
import com.metacube.dao.*;

@SuppressWarnings("serial")
public class AddEmployee extends HttpServlet {
	EmployeeDao employeeDao=new EmployeeDao();
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		PrintWriter out=resp.getWriter();
		Employee employee=new Employee(req.getParameter("first_name"),req.getParameter("last_name")
				,req.getParameter("email"),Integer.parseInt(req.getParameter("age")));
		try{
			employeeDao.insertIntoEmployee(employee);
			out.print("<script>alert('SuccesFully Added')</script>");  
			RequestDispatcher rd=req.getRequestDispatcher("/AddEmployeeForm.html");  
			rd.include(req, resp); 
		}
		catch(AssertionError e){
			out.print("<script>alert('Failed')</script>");  
			RequestDispatcher rd=req.getRequestDispatcher("/AddEmployeeForm.html");  
			rd.include(req, resp); 
		}
	}
}
