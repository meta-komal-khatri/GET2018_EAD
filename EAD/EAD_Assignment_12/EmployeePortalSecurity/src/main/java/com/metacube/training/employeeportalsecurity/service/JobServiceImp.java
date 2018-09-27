package com.metacube.training.employeeportalsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.metacube.training.employeeportalsecurity.model.Job;
import com.metacube.training.employeeportalsecurity.repository.JobRepository;


@Service
public class JobServiceImp implements JobService {

	@Autowired
	private JobRepository jobRepository ;


	@Override
	public List<Job> getAll() {
		return jobRepository.findAll();

	}

	@Override
	public boolean create(Job job) {
		try{
			jobRepository.save(job);
		}catch(Exception e){
			throw new RuntimeException();
		}
		return true;
	}

	/*@Autowired
	private JobDao jobDao;

	@Override
	public List<Job> getAll() {
		return jobDao.getAll();
	}

	@Override
	public boolean create(Job job) {
		return jobDao.create(job);
	}*/

}
