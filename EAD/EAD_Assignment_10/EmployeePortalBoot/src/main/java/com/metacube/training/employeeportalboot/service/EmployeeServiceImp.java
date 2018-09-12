package com.metacube.training.employeeportalboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.employeeportalboot.dao.EmployeeDao;
import com.metacube.training.employeeportalboot.model.Employee;
@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		return employeeDao.update(employee);
	}

	@Override
	public boolean createEmployee(Employee employee) {
		return employeeDao.create(employee);
	}

	@Override
	public boolean updateEmployeeStatus(String employeeCode, String status) {
		return employeeDao.upadteStatusOfEmployee(employeeCode, status);
	}

	@Override
	public Employee getEmployeeByEmployeeCode(String employeeCode) {
		return employeeDao.getEmployeeById(employeeCode);
	}

	@Override
	public boolean deleteEmployeeByEmployeeCode(String employeeCode) {
		return employeeDao.deleteEmployeeById(employeeCode);
	}

	@Override
	public List<Employee> selectEmployeeByName(String firstName) {
		return employeeDao.getEmployeeByName(firstName);
	}
	
	@Override
	public Employee login(String employeeCode, String password) {
		Employee employee=getEmployeeByEmployeeCode(employeeCode);
		if(employee.getPassword().equals(password)){
			return employee;
		}
		else{
			return null;
		}
	}

}
