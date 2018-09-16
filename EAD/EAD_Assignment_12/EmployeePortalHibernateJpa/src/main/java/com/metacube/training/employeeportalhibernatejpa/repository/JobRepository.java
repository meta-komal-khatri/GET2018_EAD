package com.metacube.training.employeeportalhibernatejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.employeeportalhibernatejpa.model.Job;


@Repository
public interface JobRepository extends JpaRepository<Job,Long>{

}
