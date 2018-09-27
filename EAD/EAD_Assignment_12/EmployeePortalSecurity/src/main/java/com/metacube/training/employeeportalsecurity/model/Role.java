package com.metacube.training.employeeportalsecurity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




                                                                                            
@Entity
@Table(name="Role")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="employee_code")
	private String employeeCode;
	
	@Column(name="role")
	private String role;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the employeeCOde
	 */
	public String getEmployeeCOde() {
		return employeeCode;
	}
	/**
	 * @param employeeCOde the employeeCOde to set
	 */
	public void setEmployeeCOde(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
}
