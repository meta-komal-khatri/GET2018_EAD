package com.metacube.training.employeeportalhibernatejpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.employeeportalhibernatejpa.model.Employee;
import com.metacube.training.employeeportalhibernatejpa.model.JobDetails;
import com.metacube.training.employeeportalhibernatejpa.repository.JobDetailsRepository;



@Service
public class JobDetailsServiceImp implements JobDetailService{

	
	@Autowired
	private JobDetailsRepository jobDetailsRepository;
	
	
	@Override
	public void insert(JobDetails jobDetails) {
		jobDetailsRepository.saveAndFlush(jobDetails);
		
	}

	@Override
	public List<Employee> getByProjectId(int projectId) {
		return jobDetailsRepository.findEmployeeByProjectId(projectId);
	}

}
