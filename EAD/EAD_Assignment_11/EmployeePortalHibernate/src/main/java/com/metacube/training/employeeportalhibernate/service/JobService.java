package com.metacube.training.employeeportalhibernate.service;

import java.util.List;

import com.metacube.training.employeeportalhibernate.model.Job;


public interface JobService {
	List<Job> getAll();
	boolean create(Job job);
}
