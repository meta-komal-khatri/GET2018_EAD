package com.metacube.training.employeeportalhibernatejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.employeeportalhibernatejpa.model.Projects;


@Repository
public interface ProjectRepository extends JpaRepository<Projects, Long>{
	public Projects findProjectById(int id);
	
	@Modifying
	@Transactional
	@Query("delete from Projects  where id = ?1")
	public int deleteProjectsByid(int id);
	//public boolean deleteProjectsByid(int id);
}
