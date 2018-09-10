package com.metacube.training.employeeportalboot.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.employeeportalboot.mappers.SkillMapper;
import com.metacube.training.employeeportalboot.model.Skill;
import com.metacube.training.employeeportalboot.query.Query;

@Repository
public class SkillDaoJDBCImpl implements SkillDao{

	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public SkillDaoJDBCImpl(DataSource dataSource) {
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Skill> getAll() {
		return jdbcTemplate.query(Query.SQL_GET_ALL_SKILL,new SkillMapper());
	}

	@Override
	public boolean create(Skill skill) {
		return jdbcTemplate.update(Query.SQL_INSERT_SKILL,skill.getName())>0;
	}

	@Override
	public boolean update(Skill t) {
		return false;
	}

	@Override
	public boolean delete(Skill t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
