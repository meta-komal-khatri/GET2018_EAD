package com.metacube.training.employeeportal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.employeeportal.mappers.EmployeeMapper;
import com.metacube.training.employeeportal.model.Employee;
import com.metacube.training.employeeportal.query.Query;


@Repository
public class EmployeeDaoJDBCImp implements EmployeeDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EmployeeDaoJDBCImp(DataSource dataSource) {
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	@Override
	public List<Employee> getAll() {
		return jdbcTemplate.query(Query.SQL_SELECT_EMPLOYEE,new EmployeeMapper());
	}

	@Override
	public boolean create(Employee employee) {
		return jdbcTemplate.update(Query.SQL_INSERT_EMPLOYEE,employee.getFirstName()
				,employee.getMiddleName(),employee.getLastName(),
				employee.getDob(),employee.getGender(),employee.getContactNo(),employee.getEmailId())>0;
	}

	@Override
	public boolean update(Employee employee) {
		return jdbcTemplate.update(Query.SQL_UPDATE_EMPLOYEE,employee.getFirstName()
				,employee.getMiddleName(),employee.getLastName(),
				employee.getDob(),employee.getGender(),employee.getContactNo(),employee.getEmailId())>0;
	}

	
	@Override
	public boolean delete(Employee t) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean upadteStatusOfEmployee(String employeeCode,String status) {
		return jdbcTemplate.update(Query.SQL_UPDATE_EMPLOYEE_STATUS,status,employeeCode)>0;
	}
	@Override
	public Employee getEmployeeById(String employeeCode) {
		return jdbcTemplate.queryForObject(Query.SQL_SELECT_EMPLOYEE_BY_EMPLOYEECODE,new Object[]{employeeCode}, new EmployeeMapper());
	}

}
