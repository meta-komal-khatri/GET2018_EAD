package com.metacube.training.employeeportalsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.employeeportalsecurity.model.Employee;
import com.metacube.training.employeeportalsecurity.model.Job;
import com.metacube.training.employeeportalsecurity.model.JobDetails;
import com.metacube.training.employeeportalsecurity.model.Projects;
import com.metacube.training.employeeportalsecurity.model.Skill;
import com.metacube.training.employeeportalsecurity.service.EmployeeService;
import com.metacube.training.employeeportalsecurity.service.JobService;
import com.metacube.training.employeeportalsecurity.service.ProjectService;
import com.metacube.training.employeeportalsecurity.service.SkillService;


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
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	 public ModelAndView login(){
//		 return new ModelAndView("admin/login");
//	}
//	
//	
//	@RequestMapping(value="/login" , method = RequestMethod.POST)
//	public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password){
//		return new ModelAndView("admin/dashboard","username",username);
//	}
	
	
	@RequestMapping(value="/security" ,method=RequestMethod.GET)
	public String loginSecurity(){
		return "admin/dashboard";
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
	public String addEmployee(@ModelAttribute("employee") Employee employee){
		if(employee!=null && employee.getEmployeeId()==0){
			employeeService.createEmployee(employee);
		}
		else{
			employeeService.updateEmployee(employee);
		}
		return "redirect:/admin/employes";
	}
	
	
	@RequestMapping(value="employes",method=RequestMethod.GET)
	public String showAllemployes(Model model){
		
		model.addAttribute("employes", employeeService.getAll());
		
		return "admin/employes";
	}
	
	
	@RequestMapping(value="employee/edit",method=RequestMethod.GET)
	public String editEmployee(@RequestParam("employeeCode") String employeeCode,Model model){
		Employee employee=employeeService.getEmployeeByEmployeeCode(employeeCode);
		model.addAttribute("employee" ,employee);
		
		return "admin/addemployee";
	}
	
	@RequestMapping(value="employee/delete",method=RequestMethod.GET)
	public String deleteEmployee(@RequestParam("employeeCode") String employeeCode,Model model){
		employeeService.deleteEmployeeByEmployeeCode(employeeCode);
		return "redirect:/admin/employes";
	}
	
	
	/***********************Assign Project******************************/
	
	@RequestMapping(value="employee/assign",method=RequestMethod.GET)
	public String assignProject(@RequestParam("employeeCode") String employeeCode,Model model){
		JobDetails details=new JobDetails();
		//details.setEmployeeCode(employeeCode);
		//model.addAttribute("jobDetail",details);
		return "admin/assignproject";
	}
	
	/****************Search Employee*********************/
	
	
	@RequestMapping(value="employee/search",method=RequestMethod.GET)
	public String serachEmployee(Model model){
		model.addAttribute("employee",new Employee());
		return "admin/searchemployee";
	}
	
	
	@RequestMapping(value="search",method=RequestMethod.POST)
	public String search(@ModelAttribute("employee") Employee employee,Model model){
		model.addAttribute("employes",employeeService.selectEmployeeByName(employee.getFirstName()));
		return "admin/employes";
	}
	
	
	/***************************LogOut***********************/
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logOut(Model model){
		return "admin/login";
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
