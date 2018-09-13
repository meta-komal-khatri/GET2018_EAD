package com.metacube.training.employeeportalhibernatejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.employeeportalhibernatejpa.model.Skill;


@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {
	

}
