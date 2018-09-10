package com.metacube.training.employeeportalboot.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.employeeportalboot.model.Projects;


public class ProjectMapper implements RowMapper<Projects> {

	public Projects mapRow(ResultSet resultSet, int i) throws SQLException {

		Projects project = new Projects();
		project.setId(resultSet.getInt("id"));
		project.setDescription(resultSet.getString("description"));
		project.setStartDate(resultSet.getDate("start_date"));
		project.setEndDate(resultSet.getDate("end_date"));
		return project;
	}


}
