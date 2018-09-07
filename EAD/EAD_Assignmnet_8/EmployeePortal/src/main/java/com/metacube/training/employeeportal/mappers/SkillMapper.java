package com.metacube.training.employeeportal.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.employeeportal.model.Skill;

public class SkillMapper implements RowMapper<Skill> {

	@Override
	public Skill mapRow(ResultSet resultSet, int arg1) throws SQLException {
		Skill skill= new Skill();
		skill.setId(resultSet.getInt("id"));
		skill.setName(resultSet.getString("name"));
		return skill;
	}

}
