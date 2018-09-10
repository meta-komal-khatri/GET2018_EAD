package com.metacube.training.employeeportalboot.query;

public interface Query {
	static final String SQL_FIND_PROJECT = "select * from project_master where id = ?";
	static final String SQL_DELETE_PROJECT = "delete from project_master where id = ?";
	static final String SQL_UPDATE_PROJECT = "update project_master set description = ?, start_date  = ?, end_date  = ? where id = ?";
	static final String SQL_GET_ALL = "select * from project_master";
	static final String SQL_INSERT_PROJECT = "insert into project_master(description, start_date, end_date) values(?,?,?)";
	
	
	
	static final String SQL_INSERT_SKILL="insert into skill_master (name) values (?)";
	static final String SQL_DELETE_SKILL="delete from skill_master where id=?";
	static final String SQL_GET_ALL_SKILL="SELECT * FROM skill_master";
	
	
	static final String SQL_GET_ALL_JOBS="SELECT * FROM job_title";
	static final String SQL_INSERT_JOBS="INSERT INTO job_title (title) VALUES (?)";
	
	
	static final String SQL_INSERT_EMPLOYEE="insert into employee (employee_code,first_name,\n"
			+ "middle_name,last_name,dob,gender,contact_no,email_id,password)\n"
			                        + "values(?,?,?,?,?,?,?,?,?)";
	static final String SQL_SELECT_EMPLOYEE="select * from employee";
	static final String SQL_UPDATE_EMPLOYEE="update employee set first_name=?,middle_name=?,last_name=?,dob=?,gender=?,contact_no=?,email_id=? where employee_code=?";
	static final String SQL_UPDATE_EMPLOYEE_STATUS="update employee set enabled=? where employee_code=?";
	static final String SQL_SELECT_EMPLOYEE_BY_EMPLOYEECODE="select * from employee where employee_code=?";
	static final String SQL_DELETE_EMPLOYEE="delete from employee where employee_code=?";
	static final String SQL_SELECT_EMPLOYEE_BY_FIRST_NAME="select * from employee where first_name=?";
}
