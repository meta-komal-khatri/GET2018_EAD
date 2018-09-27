package com.metacube.training.employeeportalsecurity.service;

import java.util.List;

import com.metacube.training.employeeportalsecurity.model.Job;


public interface JobService {
	List<Job> getAll();
	boolean create(Job job);
}
