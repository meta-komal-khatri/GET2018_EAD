package com.metacube.training.employeeportalsecurity.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="job_details")
public class JobDetails {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="employee_code")

	private String employeeCOde;
	
	/**
	 * @return the employeeCOde
	 */
	public String getEmployeeCOde() {
		return employeeCOde;
	}
	/**
	 * @param employeeCOde the employeeCOde to set
	 */
	public void setEmployeeCOde(String employeeCOde) {
		this.employeeCOde = employeeCOde;
	}
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_joining")
	private Date dateOfJoining;
	
	@Column(name="total_experience")
	private int totalExperience;
	
	
	@Column(name="reporting_manager")
	private String employeeManager;
	
	
	/**
	 * @return the employeeManager
	 */
	public String getEmployeeManager() {
		return employeeManager;
	}
	/**
	 * @param employeeManager the employeeManager to set
	 */
	public void setEmployeeManager(String employeeManager) {
		this.employeeManager = employeeManager;
	}
	/**
	 * @return the employeeLead
	 */
	public String getEmployeeLead() {
		return employeeLead;
	}
	/**
	 * @param employeeLead the employeeLead to set
	 */
	public void setEmployeeLead(String employeeLead) {
		this.employeeLead = employeeLead;
	}
	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	@Column(name="team_lead")
	private String employeeLead;
	
	
	@Column(name="current_project_id")
	private int projectId;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	/**
	 * @return the dateOfJoining
	 */
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	/**
	 * @return the totalExperience
	 */
	public int getTotalExperience() {
		return totalExperience;
	}
	/**
	 * @param totalExperience the totalExperience to set
	 */
	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
	}

}
