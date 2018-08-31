package com.metacube.servletassignment4.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.servletassignment4.entity.User;

public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		File file=new File(".\\ServletAssignment4\\WebContent\\images\\DefaultProfilePicture.png");
		InputStream image = new FileInputStream(file);
		try {
			User user=new User(req.getParameter("first_name"),req.getParameter("last_name"),Integer.parseInt(req.getParameter("age"))
					,(Date) new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("dob")),Integer.parseInt(req.getParameter("mobile_number")),req.getParameter("passwor"),req.getParameter("email")
					,req.getParameter("organization"),image);
		} catch (NumberFormatException | ParseException e) {
			e.printStackTrace();
		}
	}
}
