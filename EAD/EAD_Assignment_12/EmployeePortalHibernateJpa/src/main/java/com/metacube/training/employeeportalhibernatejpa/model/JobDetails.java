package com.metacube.training.employeeportalhibernatejpa.model;

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
	@ManyToOne
	@JoinColumn(name="employeeCode")
	private Employee employeeCodeObj;
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_joining")
	private Date dateOfJoining;
	
	@Column(name="total_experience")
	private int totalExperience;
	
	@ManyToOne
	@JoinColumn(name="employeeCode")
	@Column(name="reporting_manager")
	private Employee employeeManagerObj;
	
	
	@ManyToOne
	@JoinColumn(name="employeeCode")
	@Column(name="team_lead")
	private Employee employeeLeadObj;
	
	
	@ManyToOne
	@JoinColumn(name="id")
	@Column(name="current_project_id")
	private Projects project;
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
