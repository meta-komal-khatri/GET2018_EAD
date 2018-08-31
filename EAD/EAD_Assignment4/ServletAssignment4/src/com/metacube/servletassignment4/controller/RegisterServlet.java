package com.metacube.servletassignment4.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.servletassignment4.entity.User;

public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*User user=new User(req.getParameter("first_name"),req.getParameter("last_name"),Integer.parseInt(req.getParameter("age"))
				,req.getParameter("dob"),req.getParameter("mobile_number"),req.getParameter("passwor"),req.getParameter("email")
				,req.getParameter("organization"),);*/
	}
}
