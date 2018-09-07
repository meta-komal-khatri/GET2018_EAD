package com.metacube.training.employeeportal.query;

public interface Query {
	static final String SQL_FIND_PROJECT = "select * from project_master where id = ?";
	static final String SQL_DELETE_PROJECT = "delete from project_master where id = ?";
	static final String SQL_UPDATE_PROJECT = "update project_master set description = ?, start_date  = ?, end_date  = ? where id = ?";
	static final String SQL_GET_ALL = "select * from project_master";
	static final String SQL_INSERT_PROJECT = "insert into project_master(description, start_date, end_date) values(?,?,?)";
	
	
	
	static final String SQL_INSERT_SKILL="insert into skill_master (name) values (?)";
	static final String SQL_DELETE_SKILL="delete from skill_master where id=?";
	static final String SQL_GET_ALL_SKILL="SELECT * FROM skill_master";
}
