package com.metacube.training.employeeportalsecurity.service;

import java.util.List;

import com.metacube.training.employeeportalsecurity.model.Role;

public interface RoleService {
	List<Role> getRoleByEmployeeCode(String employeeCode);
}
