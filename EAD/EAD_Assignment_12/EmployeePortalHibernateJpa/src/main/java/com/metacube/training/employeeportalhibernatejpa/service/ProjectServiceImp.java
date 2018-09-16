package com.metacube.training.employeeportalhibernatejpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;






import com.metacube.training.employeeportalhibernatejpa.model.Projects;
import com.metacube.training.employeeportalhibernatejpa.repository.ProjectRepository;


@Service
public class ProjectServiceImp implements ProjectService{

	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	@Override
	public boolean createProject(Projects project) {
		try{
			projectRepository.save(project);
			
		}catch(Exception e){
			throw new RuntimeException();
		}
		return true;
	}

	@Override
	public boolean updateProject(Projects project) {
		try{
			projectRepository.save(project);
			
		}catch(Exception e){
			throw new RuntimeException();
		}
		return true;
	}
	

	@Override
	public List<Projects> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public Projects getProjectById(int id) {
		return projectRepository.findProjectById(id);
	}

	@Override
	public boolean deleteProjectById(int id) {
	return projectRepository.deleteProjectsByid(id)>0;
		
	}

	
	/*@Autowired
	private ProjectDao projectDAO;
	
	@Override
	public boolean createProject(Projects project) {
		return projectDAO.create(project);
	}

	@Override
	public boolean updateProject(Projects project) {
		return projectDAO.update(project);
	}

	@Override
	public List<Projects> getAllProjects() {
		return projectDAO.getAll();
	}
	
	@Override
	public Projects getProjectById(int id) {
		return projectDAO.getProjectById(id);
	}

	@Override
	public boolean deleteProjectById(int id) {
		return projectDAO.deleteProjectById(id);
	}*/
	
}
