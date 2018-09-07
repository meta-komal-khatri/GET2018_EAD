package com.metacube.training.employeeportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.employeeportal.model.Employee;
import com.metacube.training.employeeportal.model.Job;
import com.metacube.training.employeeportal.model.Projects;
import com.metacube.training.employeeportal.model.Skill;
import com.metacube.training.employeeportal.service.EmployeeService;
import com.metacube.training.employeeportal.service.JobService;
import com.metacube.training.employeeportal.service.ProjectService;
import com.metacube.training.employeeportal.service.SkillService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	ProjectService projectService;
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	JobService jobService;
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	 public ModelAndView login(){
		 return new ModelAndView("admin/login");
	}
	
	
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password){
		return new ModelAndView("admin/dashboard","username",username);
	}
	
	/*Project*/
	@RequestMapping(value="/project/add" , method = RequestMethod.GET)
	public ModelAndView addProject(Model model){
		model.addAttribute("project",new Projects());
		return new ModelAndView("admin/addproject");
	}
	
	@RequestMapping(value = "projects", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Projects project) {
		if(project!= null && project.getId() == 0) {
			projectService.createProject(project);	
		}else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public String getAllprojects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}
	
	@RequestMapping(value="/projects/edit",method=RequestMethod.GET)
	public ModelAndView editProject(@RequestParam("id") int id,Model model){
		Projects project=projectService.getProjectById(id);
		model.addAttribute("project", project);
		return new ModelAndView("admin/addproject");
	}
	
	@RequestMapping(value="/projects/delete",method=RequestMethod.GET)
		public String deleteProject(@RequestParam("id") int id,Model model){
			projectService.deleteProjectById(id);
			return "redirect:/admin/projects";
		}
	
	
	/*Skill*/
	
	@RequestMapping(value = "/skill/add" ,method=RequestMethod.GET)
	public String addSkills(Model model){
		model.addAttribute("skill",new Skill());
		return "admin/addskill";
	}
	
	@RequestMapping(value = "/skills" , method=RequestMethod.POST)
	public String addSkills(@ModelAttribute("skill") Skill skill,Model model){
		
		if(skill!= null && skill.getId() == 0) {
			skillService.create(skill);	
		}else {
			skillService.update(skill);
		}
		return "redirect:/admin/skills";
	}
	
	@RequestMapping(value="/skills", method = RequestMethod.GET)
	public String getAllSkills(Model model) {
		model.addAttribute("skill", skillService.getAll());
		return "admin/skills";
	}
	
	
	/******************job title***************/
	
	@RequestMapping(value="job/add", method=RequestMethod.GET)
	public String addJobTitle(Model model){
		model.addAttribute("job",new Job());
		return "admin/addjob";
	}
	
	@RequestMapping(value="jobs",method=RequestMethod.POST)
	public String addJob(Model model,@ModelAttribute("job") Job job){
		if(job!=null && job.getId()==0){
			jobService.create(job);
		}
		return "redirect:/admin/jobs";
	}
	
	@RequestMapping(value="/jobs",method=RequestMethod.GET)
	public String getAllJobs(Model model){
		model.addAttribute("job",jobService.getAll());
		return "admin/jobs";
	}
	
	
	/*******************Employee*****************/
	
	@RequestMapping(value="employee/add",method= RequestMethod.GET)
	public String addEmployee(Model model){
		model.addAttribute("employee",new Employee());
		return "admin/addemployee";
	}
	
	
	@RequestMapping(value="/employes",method=RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee,Model model){
		if(employee!=null){
			employeeService.createEmployee(employee);
		}
		return "redirect:/admin/employes";
	}
	
	
	@RequestMapping(value="employes",method=RequestMethod.GET)
	public String showAllemployes(Model model){
		model.addAttribute("employee", employeeService.getAll());
		return "admin/employes";
	}
	
	@RequestMapping(value="employee/edit",method=RequestMethod.GET)
	public String editEmployee(@RequestParam("employee_code") String employeeCode,Model model){
		employeeService.getEmployeeByEmployeeCode(employeeCode);
		return "";
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
