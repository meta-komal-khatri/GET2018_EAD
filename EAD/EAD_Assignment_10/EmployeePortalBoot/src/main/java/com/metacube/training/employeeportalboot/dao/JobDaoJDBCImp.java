package com.metacube.training.employeeportalboot.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.employeeportalboot.mappers.JobMapper;
import com.metacube.training.employeeportalboot.model.Job;
import com.metacube.training.employeeportalboot.query.Query;

@Repository
public class JobDaoJDBCImp implements JobDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JobDaoJDBCImp(DataSource dataSource){
		jdbcTemplate=new JdbcTemplate(dataSource);
	}

	@Override
	public List<Job> getAll() {
		return jdbcTemplate.query(Query.SQL_GET_ALL_JOBS,new JobMapper());
	}

	@Override
	public boolean create(Job job) {
		return jdbcTemplate.update(Query.SQL_INSERT_JOBS,job.getTitle())>0;
	}

	@Override
	public boolean update(Job t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Job t) {
		// TODO Auto-generated method stub
		return false;
	}
}
