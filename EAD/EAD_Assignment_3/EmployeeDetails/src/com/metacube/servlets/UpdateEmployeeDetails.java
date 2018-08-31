package com.metacube.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.dao.EmployeeDao;
import com.metacube.pojo.Employee;

public class UpdateEmployeeDetails extends HttpServlet {
	EmployeeDao employeeDao;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		employeeDao=new EmployeeDao();
		PrintWriter out=resp.getWriter();
		String firstName=req.getParameter("first_name");
		String lastName=req.getParameter("last_name");
		String email=req.getParameter("email");
		int age=Integer.parseInt(req.getParameter("age"));
		Employee employee=new Employee(firstName,lastName,email,age);
		System.out.println(employee.getFirstName());
		employeeDao.updateEmployeeByEmail(employee);
				
	}
}
