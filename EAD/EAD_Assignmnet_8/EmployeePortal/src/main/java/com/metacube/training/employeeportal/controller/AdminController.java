package com.metacube.training.employeeportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.employeeportal.model.Projects;
import com.metacube.training.employeeportal.service.ProjectService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	 public ModelAndView login(){
		 return new ModelAndView("admin/login");
	}
	
	
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password){
		return new ModelAndView("admin/dashboard","username",username);
	}
	
	
	@RequestMapping(value="/project/add" , method = RequestMethod.GET)
	public ModelAndView addProject(Model model){
		System.out.println("ajksdh");
		model.addAttribute("project",new Projects());
		return new ModelAndView("admin/addproject");
	}
	
	@RequestMapping(path = "projects", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Projects project) {
		System.out.println("nsjsd");
		if(project!= null && project.getId() == 0) {
			projectService.createProject(project);	
		}else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}
	
	@RequestMapping(path = "/projects", method = RequestMethod.GET)
	public String getAllprojects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}
	
	@RequestMapping(path="/projects/edit",method=RequestMethod.GET)
	public String editProject(@RequestParam("id") int id,Model model){
		model.addAttribute("projects", new Projects());
		return "sjd";
	}
	
	
	
	
	
	
	/*@RequestMapping(value="/addskill" , method = RequestMethod.GET)
	public ModelAndView addSkill1(){
		return new ModelAndView("admin/addskill");
	}
	
	@RequestMapping(value="/addskill" , method = RequestMethod.POST)
	public ModelAndView addProject1(){
		return new ModelAndView("admin/dashboard");
	}
	
	
	@RequestMapping(value="/addjob" , method = RequestMethod.GET)
	public ModelAndView addJob(){
		return new ModelAndView("admin/addjob");
	}
	
	@RequestMapping(value="/addjob" , method = RequestMethod.POST)
	public ModelAndView addJob1(){
		return new ModelAndView("admin/dashboard");
	}*/
}
