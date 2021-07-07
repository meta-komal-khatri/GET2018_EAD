package com.metacube.training.employeeportal.dao;

import com.metacube.training.employeeportal.model.Projects;

public interface ProjectDao extends BaseDao<Projects> {
	public Projects getProjectById(int id);
	public boolean deleteProjectById(int id);
}
