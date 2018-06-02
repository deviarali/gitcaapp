package com.ajahsma.caapp.dto;

import java.util.Date;

public class TasksDto 
{
	private int id;
	private ClientDto clientDto;
	private NatureOfAssignmentDto natureOfAssignmentDto;
	private String taskRemarksByEmployee;
	private String taskRemarksByAdmin;
	private String taskVerifiedBy;
	private EmployeeDto taskAssigneeId;
	private Date taskCreatedDate;
	private Date taskStartDate;
	private TasksStatusDto taskStatusId;
	private String[] tasks;
	private String startDate;
	
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
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
	 * @return the clientDto
	 */
	public ClientDto getClientDto() {
		return clientDto;
	}
	/**
	 * @param clientDto the clientDto to set
	 */
	public void setClientDto(ClientDto clientDto) {
		this.clientDto = clientDto;
	}
	/**
	 * @return the natureOfAssignmentDto
	 */
	public NatureOfAssignmentDto getNatureOfAssignmentDto() {
		return natureOfAssignmentDto;
	}
	/**
	 * @param natureOfAssignmentDto the natureOfAssignmentDto to set
	 */
	public void setNatureOfAssignmentDto(NatureOfAssignmentDto natureOfAssignmentDto) {
		this.natureOfAssignmentDto = natureOfAssignmentDto;
	}
	/**
	 * @return the taskRemarksByEmployee
	 */
	public String getTaskRemarksByEmployee() {
		return taskRemarksByEmployee;
	}
	/**
	 * @param taskRemarksByEmployee the taskRemarksByEmployee to set
	 */
	public void setTaskRemarksByEmployee(String taskRemarksByEmployee) {
		this.taskRemarksByEmployee = taskRemarksByEmployee;
	}
	/**
	 * @return the taskRemarksByAdmin
	 */
	public String getTaskRemarksByAdmin() {
		return taskRemarksByAdmin;
	}
	/**
	 * @param taskRemarksByAdmin the taskRemarksByAdmin to set
	 */
	public void setTaskRemarksByAdmin(String taskRemarksByAdmin) {
		this.taskRemarksByAdmin = taskRemarksByAdmin;
	}
	/**
	 * @return the taskVerifiedBy
	 */
	public String getTaskVerifiedBy() {
		return taskVerifiedBy;
	}
	/**
	 * @param taskVerifiedBy the taskVerifiedBy to set
	 */
	public void setTaskVerifiedBy(String taskVerifiedBy) {
		this.taskVerifiedBy = taskVerifiedBy;
	}
	/**
	 * @return the taskAssigneeId
	 */
	public EmployeeDto getTaskAssigneeId() {
		return taskAssigneeId;
	}
	/**
	 * @param taskAssigneeId the taskAssigneeId to set
	 */
	public void setTaskAssigneeId(EmployeeDto taskAssigneeId) {
		this.taskAssigneeId = taskAssigneeId;
	}
	/**
	 * @return the taskCreatedDate
	 */
	public Date getTaskCreatedDate() {
		return taskCreatedDate;
	}
	/**
	 * @param taskCreatedDate the taskCreatedDate to set
	 */
	public void setTaskCreatedDate(Date taskCreatedDate) {
		this.taskCreatedDate = taskCreatedDate;
	}
	/**
	 * @return the taskStartDate
	 */
	
	public Date getTaskStartDate() {
		return taskStartDate;
	}
	/**
	 * @param taskStartDate the taskStartDate to set
	 */
	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}
	/**
	 * @return the taskStatusId
	 */
	public TasksStatusDto getTaskStatusId() {
		return taskStatusId;
	}
	/**
	 * @param taskStatusId the taskStatusId to set
	 */
	public void setTaskStatusId(TasksStatusDto taskStatusId) {
		this.taskStatusId = taskStatusId;
	}
	/**
	 * @return the tasks
	 */
	public String[] getTasks() {
		return tasks;
	}
	/**
	 * @param tasks the tasks to set
	 */
	public void setTasks(String[] tasks) {
		this.tasks = tasks;
	}
	
	
	
}
