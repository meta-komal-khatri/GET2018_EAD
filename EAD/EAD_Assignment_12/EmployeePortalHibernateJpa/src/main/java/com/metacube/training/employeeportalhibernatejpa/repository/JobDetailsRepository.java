package com.metacube.training.employeeportalhibernatejpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.employeeportalhibernatejpa.model.Employee;
import com.metacube.training.employeeportalhibernatejpa.model.JobDetails;

public interface JobDetailsRepository extends JpaRepository<JobDetails, Long> {
	public List<Employee> findEmployeeByProjectId(int projectId);
}
