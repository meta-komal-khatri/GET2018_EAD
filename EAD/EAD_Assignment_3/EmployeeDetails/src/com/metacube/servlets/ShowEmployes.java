package com.metacube.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.dao.ConnectionHelper;
import com.metacube.dao.EmployeeDao;
import com.metacube.pojo.Employee;

@SuppressWarnings("serial")
public class ShowEmployes extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EmployeeDao employeeDao=new EmployeeDao();
		
		List<Employee> employeeList=new ArrayList<Employee>();
		
		PrintWriter out=resp.getWriter();
		
		try{
		
			employeeList=employeeDao.selectAllEmployes();
		
			out.println("<html>"
				+ "<body>"
					+"<table border=1 font='italic'>");
		
			for(Employee employee:employeeList){
				out.println("<tr>");
				out.println("<form action='Update' method='get'>");
				out.println("<td>"+employee.getFirstName()+"</td>");
				out.println("<td>"+employee.getLastName()+"</td>");
				out.println("<td>"+employee.getEmail()+"</td>");
				out.println("<td>"+employee.getAge()+"</td>");
				out.println("<td><input type='text' name='email' value="+employee.getEmail()+"></td>");
				out.println("<td>"
						+ "<input type='submit' value='Update'></td>");
				out.println("</tr>");
				out.println("</form>");
			}
			out.println("</table></body></html>");
		
			RequestDispatcher rd=req.getRequestDispatcher("/showEmployee.html");  
		
			rd.include(req, resp);
		
		}catch(AssertionError e){
			out.print("<script>alert('Failed')</script>");  
			RequestDispatcher rd=req.getRequestDispatcher("/AddEmployeeForm.html");  
			rd.include(req, resp); 
		}
	}
}
