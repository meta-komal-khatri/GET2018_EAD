package com.metacube.training.employeeportalsecurity.service;

import java.util.List;

import com.metacube.training.employeeportalsecurity.model.Employee;
import com.metacube.training.employeeportalsecurity.model.JobDetails;



public interface JobDetailService {
	public void insert(JobDetails jobDetails);
	public List<Employee> getByProjectId(int projectId);
}
