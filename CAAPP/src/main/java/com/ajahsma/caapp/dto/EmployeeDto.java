package com.ajahsma.caapp.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeDto 
{
	private Long employeeId;
	private String employeeName;
	private String employeeAddress;
	private String employeeMobile;
	private String employeeEmail;
	private String employeePan;
	private String employeeAadhar;
	private String employeeParentAddress;
	private String employeeStatus;
	private Date employeeCreatedDate;
	
	private ApplicationUserDto applicationUser;
	
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	private Date employeeJoingDate;
	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/**
	 * @return the employeeAddress
	 */
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	/**
	 * @param employeeAddress the employeeAddress to set
	 */
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	/**
	 * @return the employeeMobile
	 */
	public String getEmployeeMobile() {
		return employeeMobile;
	}
	/**
	 * @param employeeMobile the employeeMobile to set
	 */
	public void setEmployeeMobile(String employeeMobile) {
		this.employeeMobile = employeeMobile;
	}
	/**
	 * @return the employeeEmail
	 */
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	/**
	 * @param employeeEmail the employeeEmail to set
	 */
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	/**
	 * @return the employeePan
	 */
	public String getEmployeePan() {
		return employeePan;
	}
	/**
	 * @param employeePan the employeePan to set
	 */
	public void setEmployeePan(String employeePan) {
		this.employeePan = employeePan;
	}
	/**
	 * @return the employeeAadhar
	 */
	public String getEmployeeAadhar() {
		return employeeAadhar;
	}
	/**
	 * @param employeeAadhar the employeeAadhar to set
	 */
	public void setEmployeeAadhar(String employeeAadhar) {
		this.employeeAadhar = employeeAadhar;
	}
	/**
	 * @return the employeeParentAddress
	 */
	public String getEmployeeParentAddress() {
		return employeeParentAddress;
	}
	/**
	 * @param employeeParentAddress the employeeParentAddress to set
	 */
	public void setEmployeeParentAddress(String employeeParentAddress) {
		this.employeeParentAddress = employeeParentAddress;
	}
	/**
	 * @return the employeeStatus
	 */
	public String getEmployeeStatus() {
		return employeeStatus;
	}
	/**
	 * @param employeeStatus the employeeStatus to set
	 */
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	/**
	 * @return the employeeCreatedDate
	 */
	public Date getEmployeeCreatedDate() {
		return employeeCreatedDate;
	}
	/**
	 * @param employeeCreatedDate the employeeCreatedDate to set
	 */
	public void setEmployeeCreatedDate(Date employeeCreatedDate) {
		this.employeeCreatedDate = employeeCreatedDate;
	}
	/**
	 * @return the employeeJoingDate
	 */
	public Date getEmployeeJoingDate() {
		return employeeJoingDate;
	}
	/**
	 * @param employeeJoingDate the employeeJoingDate to set
	 */
	public void setEmployeeJoingDate(Date employeeJoingDate) {
		this.employeeJoingDate = employeeJoingDate;
	}

	public ApplicationUserDto getApplicationUser() {
		return applicationUser;
	}
	
	public void setApplicationUser(ApplicationUserDto applicationUser) {
		this.applicationUser = applicationUser;
	}
	
	
}
