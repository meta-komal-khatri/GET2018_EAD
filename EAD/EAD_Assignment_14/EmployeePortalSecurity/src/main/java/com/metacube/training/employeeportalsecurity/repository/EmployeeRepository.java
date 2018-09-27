package com.metacube.training.employeeportalsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.employeeportalsecurity.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	
	public Employee findEmployeeByEmployeeCode(String employeeCode);
	
	@Modifying
	@Query("update Employee set status=?1 where employeeCode=?2")
	public void updateEmployeeStatusByemployeeCode(String status,String employeeCode);
	
	
	
	public List<Employee> findEmployeeByfirstName(String firstName);
	
	
	@Modifying
	@Query("delete from Employee  where employeeCode = ?1")
	public int deleteEmployeeByemployeeCode(String employeeCode);
	}
 