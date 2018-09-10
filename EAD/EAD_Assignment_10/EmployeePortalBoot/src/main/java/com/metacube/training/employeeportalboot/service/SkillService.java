package com.metacube.training.employeeportalboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.training.employeeportalboot.model.Skill;



public interface SkillService {
	public boolean create(Skill skill);
	public boolean delete(Skill skill);
	public boolean update(Skill skill);
	public List<Skill> getAll();
}
