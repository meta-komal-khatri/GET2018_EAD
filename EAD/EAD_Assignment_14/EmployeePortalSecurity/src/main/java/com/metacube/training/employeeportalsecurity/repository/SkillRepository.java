package com.metacube.training.employeeportalsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.employeeportalsecurity.model.Skill;


@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {
	

}
