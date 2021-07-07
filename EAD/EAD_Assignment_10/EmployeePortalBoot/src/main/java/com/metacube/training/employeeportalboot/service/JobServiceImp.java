package com.metacube.training.employeeportalboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.employeeportalboot.dao.JobDao;
import com.metacube.training.employeeportalboot.model.Job;


@Service
public class JobServiceImp implements JobService {

	@Autowired
	private JobDao jobDao;
	
	@Override
	public List<Job> getAll() {
		return jobDao.getAll();
	}

	@Override
	public boolean create(Job job) {
		return jobDao.create(job);
	}
	
}
