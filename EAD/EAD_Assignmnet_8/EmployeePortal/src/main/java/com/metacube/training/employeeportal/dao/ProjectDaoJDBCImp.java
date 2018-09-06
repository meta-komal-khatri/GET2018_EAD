package com.metacube.training.employeeportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.metacube.training.employeeportal.model.Projects;
import com.metacube.training.employeeportal.query.Query;
import com.metacube.training.employeeportal.mappers.ProjectMapper;

@Repository
public class ProjectDaoJDBCImp implements ProjectDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ProjectDaoJDBCImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<Projects> getAll() {
		return jdbcTemplate.query(Query.SQL_GET_ALL, new ProjectMapper());
	}

	@Override
	public boolean create(Projects project) {	
		return jdbcTemplate.update(Query.SQL_INSERT_PROJECT, project.getDescription(), project.getStartDate(),
				project.getEndDate()) > 0;
		
	}

	@Override
	public void update(Projects t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Projects t) {
		// TODO Auto-generated method stub
		
	}

}
