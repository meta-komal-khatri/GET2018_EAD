package com.metacube.training.employeeportalsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.employeeportalsecurity.model.Job;
import com.metacube.training.employeeportalsecurity.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
	List<Role> findByEmployeeCode(String employeeCode);
}
