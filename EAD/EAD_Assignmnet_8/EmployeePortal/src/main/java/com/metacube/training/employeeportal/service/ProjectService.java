package com.metacube.training.employeeportal.service;

import java.util.List;

import com.metacube.training.employeeportal.model.Projects;


public interface ProjectService {
	boolean createProject(Projects project);

	boolean updateProject(Projects project);

	List<Projects> getAllProjects();
}
