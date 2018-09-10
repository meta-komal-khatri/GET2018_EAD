package com.metacube.training.employeeportalboot.dao;

import java.util.List;

import com.metacube.training.employeeportalboot.model.Employee;

public interface EmployeeDao extends BaseDao<Employee> {
	public boolean upadteStatusOfEmployee(String employeeCode,String status);
	public Employee getEmployeeById(String employeeCode);
	public boolean deleteEmployeeById(String employeeCode);
	public List<Employee> getEmployeeByName(String firstName);
	
}
