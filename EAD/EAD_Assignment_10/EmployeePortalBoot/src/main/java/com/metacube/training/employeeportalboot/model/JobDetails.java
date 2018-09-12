package com.metacube.training.employeeportalboot.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class JobDetails {
	private int id;
	
	@NotEmpty
	private String employeeCode;
	
	@NotNull
	private Date dateOfJoining;
	@NotNull
	private int totalExperience;
	@NotNull
	private int reportingManger;
	@NotNull
	private int teamLead;
	@NotNull
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
	public String getEmployeeCode() {
		return employeeCode;
	}
	
	/**
	 * @param employeeCode the employeeCode to set
	 */
	public void setEmployeeCode(String employeeCode) {
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
