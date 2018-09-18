package com.metacube.training.employeeportalsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.employeeportalsecurity.service.EmployeeService;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	 public ModelAndView login(){
		 return new ModelAndView("employee/login");
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("username") String employeeCode,@RequestParam("password") String password,Model model){
		if(employeeService.login(employeeCode, password)!=null){
			model.addAttribute("employee",employeeService.login(employeeCode, password));
			return "employee/dashboard";
		}
		else{
			model.addAttribute("message", "Invalid user or password");
			return "employee/login";
		}
		
	}
	
	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public String profile(@RequestParam("id") String employeeCode,Model model){
		model.addAttribute("employee" , employeeService.getEmployeeByEmployeeCode(employeeCode) );
		return "employee/profile";
	}
	
	@RequestMapping(value="/profile/edit",method=RequestMethod.GET)
	public String editProfile(Model model,@RequestParam("employeeCode") String employeeCode){
		System.out.println("ksjdjkc");
		model.addAttribute("employee" , employeeService.getEmployeeByEmployeeCode(employeeCode) );
		model.addAttribute("visibility","hidden");
		return "employee/profile";
	}
}
