package com.metacube.training.employeeportalhibernatejpa.service;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



import org.springframework.transaction.annotation.Transactional;



import com.metacube.training.employeeportalhibernatejpa.model.Employee;
import com.metacube.training.employeeportalhibernatejpa.repository.EmployeeRepository;
@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	@Transactional
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	@Transactional
	public boolean updateEmployee(Employee employee) {
	          employeeRepository.save(employee);
			return true;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		try{
		employeeRepository.save(employee);
		
		}
		catch(Exception e){
			throw new RuntimeException();
		}
		return true;
		
		
	}

	@Override
	@Transactional
	public boolean updateEmployeeStatus(String employeeCode, String status) {
		employeeRepository.updateEmployeeStatusByemployeeCode(status, employeeCode);
		return true;
		
		
	}

	@Override
	@Transactional
	public Employee getEmployeeByEmployeeCode(String employeeCode) {
		return employeeRepository.findEmployeeByEmployeeCode(employeeCode);
	}

	@Override
	public boolean deleteEmployeeByEmployeeCode(String employeeCode) {
		return employeeRepository.deleteEmployeeByemployeeCode(employeeCode)>0;
		
		
	}

	@Override
	public List<Employee> selectEmployeeByName(String firstName) {
		return employeeRepository.findEmployeeByfirstName(firstName);
		
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
