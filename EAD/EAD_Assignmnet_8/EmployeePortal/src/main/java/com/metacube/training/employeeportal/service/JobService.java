package com.metacube.training.employeeportal.service;

import java.util.List;

import com.metacube.training.employeeportal.model.Job;


public interface JobService {
	List<Job> getAll();
	boolean create(Job job);
}
