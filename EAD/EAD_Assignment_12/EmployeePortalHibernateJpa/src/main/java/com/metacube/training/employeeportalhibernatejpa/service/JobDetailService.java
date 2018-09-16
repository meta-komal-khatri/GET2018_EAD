package com.metacube.training.employeeportalhibernatejpa.service;

import java.util.List;

import com.metacube.training.employeeportalhibernatejpa.model.Employee;
import com.metacube.training.employeeportalhibernatejpa.model.JobDetails;



public interface JobDetailService {
	public void insert(JobDetails jobDetails);
	public List<Employee> getByProjectId(int projectId);
}
