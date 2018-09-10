package com.metacube.training.employeeportalboot.service;

import java.util.List;

import com.metacube.training.employeeportalboot.model.Job;


public interface JobService {
	List<Job> getAll();
	boolean create(Job job);
}
