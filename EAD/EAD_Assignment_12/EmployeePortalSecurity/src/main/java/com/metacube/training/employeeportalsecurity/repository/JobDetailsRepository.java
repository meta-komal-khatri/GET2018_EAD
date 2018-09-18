package com.metacube.training.employeeportalsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.employeeportalsecurity.model.Employee;
import com.metacube.training.employeeportalsecurity.model.JobDetails;

public interface JobDetailsRepository extends JpaRepository<JobDetails, Long> {
	public List<Employee> findEmployeeByProjectId(int projectId);
}
