package com.metacube.training.employeeportalhibernate.dao;

import com.metacube.training.employeeportalhibernate.model.Projects;

public interface ProjectDao extends BaseDao<Projects> {
	public Projects getProjectById(int id);
	public boolean deleteProjectById(int id);
}
