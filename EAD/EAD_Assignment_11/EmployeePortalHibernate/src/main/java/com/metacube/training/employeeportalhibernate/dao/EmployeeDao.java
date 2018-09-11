package com.metacube.training.employeeportalhibernate.dao;

import java.util.List;

import com.metacube.training.employeeportalhibernate.model.Employee;

public interface EmployeeDao extends BaseDao<Employee> {
	public boolean upadteStatusOfEmployee(String employeeCode,String status);
	public Employee getEmployeeById(String employeeCode);
	public boolean deleteEmployeeById(String employeeCode);
	public List<Employee> getEmployeeByName(String firstName);
	
	
}
