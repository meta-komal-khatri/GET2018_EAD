package com.metacube.training.employeeportal.dao;

import com.metacube.training.employeeportal.model.Employee;

public interface EmployeeDao extends BaseDao<Employee> {
	public boolean upadteStatusOfEmployee(String employeeCode,String status);
	public Employee getEmployeeById(String employeeCode);
	
}
