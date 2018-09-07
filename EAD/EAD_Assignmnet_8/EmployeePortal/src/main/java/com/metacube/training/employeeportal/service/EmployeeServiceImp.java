package com.metacube.training.employeeportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.metacube.training.employeeportal.dao.EmployeeDao;
import com.metacube.training.employeeportal.model.Employee;

public class EmployeeServiceImp implements EmployeeDao {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	@Override
	public boolean create(Employee employee) {
		return employeeDao.create(employee);
	}

	@Override
	public boolean update(Employee employee) {
		return employeeDao.update(employee);
	}

	@Override
	public boolean delete(Employee t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean upadteStatusOfEmployee(String employeeCode, String status) {
		return employeeDao.upadteStatusOfEmployee(employeeCode, status);
	}

	@Override
	public Employee getEmployeeById(String employeeCode) {
		return employeeDao.getEmployeeById(employeeCode);
	}

}
