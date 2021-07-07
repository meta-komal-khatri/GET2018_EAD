package com.metacube.training.employeeportalhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.employeeportalhibernate.dao.JobDao;
import com.metacube.training.employeeportalhibernate.model.Job;


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
