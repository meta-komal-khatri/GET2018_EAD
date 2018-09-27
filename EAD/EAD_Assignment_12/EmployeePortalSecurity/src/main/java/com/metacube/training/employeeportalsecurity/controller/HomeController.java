package com.metacube.training.employeeportalsecurity.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	@RequestMapping(value="/login" ,method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value="/default",method=RequestMethod.GET)
	public String afterLogin(HttpServletRequest request){
		 if (request.isUserInRole("ROLE_ADMIN")) {
	            return "redirect:/admin/security";
	        }
	        return "redirect:/employee/dashboard";
	}
} 
