package com.metacube.training.employeeportalboot.service;

import java.util.List;

import com.metacube.training.employeeportalboot.model.Projects;


public interface ProjectService {
	boolean createProject(Projects project);

	boolean updateProject(Projects project);

	List<Projects> getAllProjects();
	
	Projects getProjectById(int id);
	boolean deleteProjectById(int id);
}
