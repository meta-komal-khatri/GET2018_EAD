package com.metacube.training.employeeportalhibernate.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private int employeeCode;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_joining")
	private Date dateOfJoining;
	
	@Column(name="total_experience")
	private int totalExperience;
	
	@Column(name="reporting_manager")
	private int reportingManger;
	
	@Column(name="team_lead")
	private int teamLead;
	
	@Column(name="current_project_id")
	private int currentProjectId;
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
	 * @return the employeeCode
	 */
	public int getEmployeeCode() {
		return employeeCode;
	}
	
	/**
	 * @param employeeCode the employeeCode to set
	 */
	public void setEmployeeCode(int employeeCode) {
		this.employeeCode = employeeCode;
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
	/**
	 * @return the reportingManger
	 */
	public int getReportingManger() {
		return reportingManger;
	}
	/**
	 * @param reportingManger the reportingManger to set
	 */
	public void setReportingManger(int reportingManger) {
		this.reportingManger = reportingManger;
	}
	/**
	 * @return the teamLead
	 */
	public int getTeamLead() {
		return teamLead;
	}
	/**
	 * @param teamLead the teamLead to set
	 */
	public void setTeamLead(int teamLead) {
		this.teamLead = teamLead;
	}
	/**
	 * @return the currentProjectId
	 */
	public int getCurrentProjectId() {
		return currentProjectId;
	}
	/**
	 * @param currentProjectId the currentProjectId to set
	 */
	public void setCurrentProjectId(int currentProjectId) {
		this.currentProjectId = currentProjectId;
	}
}
