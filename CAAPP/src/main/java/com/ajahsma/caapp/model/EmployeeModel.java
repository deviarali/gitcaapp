package com.ajahsma.caapp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "Employee")
@Table(name = "employee")
public class EmployeeModel extends AbstractIdDomain { 
	
	private String employeeName;
	private String employeeAddress;
	private String employeeMobile;
	private String employeeEmail;
	private String employeePan;
	private String employeeAadhar;
	private String employeeParentAddress;
	private String employeeStatus;
	private Date employeeCreatedDate;
	private Date employeeJoingDate;
	
	private ApplicationUserModel applicationUser;
	
	@Column(name = "name")
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Column(name = "address")
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	/**
	 * @param employeeAddress the employeeAddress to set
	 */
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	@Column(name = "mobile")
	public String getEmployeeMobile() {
		return employeeMobile;
	}

	public void setEmployeeMobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}

	@Column(name = "email")
	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	@Column(name = "pan")
	public String getEmployeePan() {
		return employeePan;
	}

	public void setEmployeePan(String employeePan) {
		this.employeePan = employeePan;
	}

	@Column(name = "aadhar")
	public String getEmployeeAadhar() {
		return employeeAadhar;
	}

	public void setEmployeeAadhar(String employeeAadhar) {
		this.employeeAadhar = employeeAadhar;
	}

	@Column(name = "parentaddress")
	public String getEmployeeParentAddress() {
		return employeeParentAddress;
	}

	public void setEmployeeParentAddress(String employeeParentAddress) {
		this.employeeParentAddress = employeeParentAddress;
	}

	@Column(name = "status")
	public String getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	@Column(name = "createddate")
	public Date getEmployeeCreatedDate() {
		return employeeCreatedDate;
	}

	public void setEmployeeCreatedDate(Date employeeCreatedDate) {
		this.employeeCreatedDate = employeeCreatedDate;
	}

	@Column(name = "doj", nullable= false)
	public Date getEmployeeJoingDate() {
		return employeeJoingDate;
	}

	public void setEmployeeJoingDate(Date employeeJoingDate) {
		this.employeeJoingDate = employeeJoingDate;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "applicationuser_id", nullable = true)
	public ApplicationUserModel getApplicationUser() {
		return applicationUser;
	}
	
	public void setApplicationUser(ApplicationUserModel applicationUser) {
		this.applicationUser = applicationUser;
	}
}
