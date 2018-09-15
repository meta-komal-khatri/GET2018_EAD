package com.metacube.training.employeeportalhibernatejpa.service;

import java.util.List;

import com.metacube.training.employeeportalhibernatejpa.model.Projects;


public interface ProjectService {
	boolean createProject(Projects project);

	boolean updateProject(Projects project);

	List<Projects> getAllProjects();
	
	Projects getProjectById(int id);
	boolean deleteProjectById(int id);
}
