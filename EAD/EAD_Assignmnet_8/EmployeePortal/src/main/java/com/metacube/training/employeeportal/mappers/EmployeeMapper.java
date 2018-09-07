package com.metacube.training.employeeportal.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.employeeportal.model.Employee;
import com.metacube.training.employeeportal.model.Job;

public class EmployeeMapper implements RowMapper<Employee> {
	@Override
	public Employee mapRow(ResultSet resultSet, int arg) throws SQLException {
		Employee employee =new Employee();
		employee.setEmployeeCode(resultSet.getString("employee_code"));
		employee.setFirstName(resultSet.getString("first_name"));
		employee.setMiddleName(resultSet.getString("middle_name"));
		employee.setDob(resultSet.getDate("dob"));
		
		employee.setGender(resultSet.getString("gender"));
		employee.setContactNo(resultSet.getInt("contact_no"));
		employee.setEmailId(resultSet.getString("email_id"));
		employee.setEmployeeCode(resultSet.getString("employee_code"));
		return employee;
		
	}
}
