package com.metacube.training.employeeportalboot.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.metacube.training.employeeportalboot.model.Projects;
import com.metacube.training.employeeportalboot.query.Query;
import com.metacube.training.employeeportalboot.mappers.ProjectMapper;

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
	public boolean update(Projects project) {
		return jdbcTemplate.update(Query.SQL_UPDATE_PROJECT,project.getDescription(),project.getStartDate(),project.getEndDate(),project.getId())>0;
		
	}

	@Override
	public boolean delete(Projects t) {
		return false;
		
	}


	@Override
	public Projects getProjectById(int id) {
		return (Projects) jdbcTemplate.queryForObject(Query.SQL_FIND_PROJECT,new Object[]{id},new ProjectMapper());
	}


	@Override
	public boolean deleteProjectById(int id) {
		return jdbcTemplate.update(Query.SQL_DELETE_PROJECT,new Object[]{id})>0;
	}

}
