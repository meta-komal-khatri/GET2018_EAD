package com.metacube.training.employeeportalhibernatejpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.metacube.training.employeeportalhibernatejpa.model.Skill;


@Service
public class SkillServiceImp implements SkillService {

	@Override
	public boolean create(Skill skill) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Skill skill) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Skill skill) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Skill> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
/*	@Autowired
	private SkillDao skillDao;

	@Override
	public boolean create(Skill skill) {
		return skillDao.create(skill);
	}

	@Override
	public boolean delete(Skill skill) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Skill skill) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Skill> getAll() {
		return skillDao.getAll();
	}*/
}
