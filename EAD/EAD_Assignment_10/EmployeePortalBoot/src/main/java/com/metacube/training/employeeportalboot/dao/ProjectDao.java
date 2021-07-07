package com.metacube.training.employeeportalboot.dao;

import com.metacube.training.employeeportalboot.model.Projects;

public interface ProjectDao extends BaseDao<Projects> {
	public Projects getProjectById(int id);
	public boolean deleteProjectById(int id);
}
