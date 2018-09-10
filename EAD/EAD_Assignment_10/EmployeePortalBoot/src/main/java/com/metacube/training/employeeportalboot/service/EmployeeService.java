package com.metacube.training.employeeportalboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.training.employeeportalboot.model.Employee;


public interface EmployeeService {
	List<Employee> getAll();
	boolean updateEmployee(Employee employee);
	boolean createEmployee(Employee employee);
	boolean updateEmployeeStatus(String employeeCode,String status);
	Employee getEmployeeByEmployeeCode(String employeeCode);
	boolean deleteEmployeeByEmployeeCode(String employeeCode);
	List<Employee> selectEmployeeByName(String firstName);
	
}
