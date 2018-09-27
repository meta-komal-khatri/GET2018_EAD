package com.metacube.training.employeeportalsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.employeeportalsecurity.model.Role;
import com.metacube.training.employeeportalsecurity.repository.RoleRepository;

@Service
public class RoleServiceImp implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	@Override
	public List<Role> getRoleByEmployeeCode(String employeeCode) {
		return roleRepository.findByEmployeeCode(employeeCode);
	}

}
