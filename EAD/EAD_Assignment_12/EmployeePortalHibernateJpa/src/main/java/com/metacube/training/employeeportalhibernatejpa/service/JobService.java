package com.metacube.training.employeeportalhibernatejpa.service;

import java.util.List;

import com.metacube.training.employeeportalhibernatejpa.model.Job;


public interface JobService {
	List<Job> getAll();
	boolean create(Job job);
}
