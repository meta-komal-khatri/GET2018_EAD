package com.metacube.training.EmployeePortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	 public ModelAndView login(){
		 
		 return new ModelAndView("admin/login");
	 }
	
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password){
		return new ModelAndView("admin/dashboard","username",username);
	}
	
	@RequestMapping(value="/addproject" , method = RequestMethod.GET)
	public ModelAndView addProject(){
		return new ModelAndView("admin/addproject");
	}
	
	@RequestMapping(value="/addproject" , method = RequestMethod.POST)
	public ModelAndView addSkill(){
		return new ModelAndView("admin/dashboard");
	}
	
	@RequestMapping(value="/addskill" , method = RequestMethod.GET)
	public ModelAndView addSkill1(){
		return new ModelAndView("admin/addskill");
	}
	
	@RequestMapping(value="/addskill" , method = RequestMethod.POST)
	public ModelAndView addProject1(){
		return new ModelAndView("admin/dashboard");
	}
	
	
	@RequestMapping(value="/addjob" , method = RequestMethod.GET)
	public ModelAndView addJob(){
		return new ModelAndView("admin/addskill");
	}
	
	@RequestMapping(value="/addjob" , method = RequestMethod.POST)
	public ModelAndView addJob1(){
		return new ModelAndView("admin/dashboard");
	}
}
