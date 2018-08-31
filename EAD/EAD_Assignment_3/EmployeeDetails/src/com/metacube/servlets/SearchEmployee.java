package com.metacube.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.dao.ConnectionHelper;
import com.metacube.dao.EmployeeDao;
import com.metacube.pojo.Employee;

public class SearchEmployee extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException,AssertionError {
		EmployeeDao employeeDao=new EmployeeDao();
		PrintWriter out=resp.getWriter();
		String firstName=req.getParameter("first_name");
		String lastName=req.getParameter("last_name");

		if(firstName.length()<=0 || lastName.length()<=0){
			out.println("<script>alert('empty textbox')</script>");
			RequestDispatcher rd=req.getRequestDispatcher("/search_employee.html");  
			rd.include(req, resp);
		}
		else{
			List<Employee> employeeList=employeeDao.selectAllEmployeeByNameAndLastName(firstName, lastName);
			if(employeeList.size()==0){
				out.println("<script>alert('no such employee available')</script>");
				RequestDispatcher rd=req.getRequestDispatcher("/search_employee.html");  
				rd.include(req, resp);
			}
			else{
				out.println("<html>"
						+ "<body>"
						+"<table border=1 font='italic'>");
				for(Employee employee:employeeList){
					out.println("<tr>");
					out.println("<td>"+employee.getFirstName()+"</td>");
					out.println("<td>"+employee.getLastName()+"</td>");
					out.println("<td>"+employee.getEmail()+"</td>");
					out.println("<td>"+employee.getAge()+"</td>");
					out.println("</tr>");
				}
				out.println("</table></body></html>");
			}
		}
	}
}
