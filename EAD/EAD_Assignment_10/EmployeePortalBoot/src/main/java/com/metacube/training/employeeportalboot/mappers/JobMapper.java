package com.metacube.training.employeeportalboot.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.employeeportalboot.model.Job;

public class JobMapper implements RowMapper<Job> {

	@Override
	public Job mapRow(ResultSet resultSet, int arg) throws SQLException {
		Job job=new Job();
		job.setId(resultSet.getInt("job_code"));
		job.setTitle(resultSet.getString("title"));
		return job;
	}
	
	
}
