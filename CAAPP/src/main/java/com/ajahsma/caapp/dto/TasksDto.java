package com.ajahsma.caapp.dto;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import com.ajahsma.caapp.model.PriorityStatus;
import com.ajahsma.caapp.model.TaskStatus;

public class TasksDto 
{
	private Long id;
	private ClientDto clientDto;
	private NatureOfAssignmentDto natureOfAssignmentDto;
	private String taskRemarksByEmployee;
	private String taskRemarksByAdmin;
	private String taskVerifiedBy;
	private EmployeeDto taskAssigneeId;

	@DateTimeFormat(pattern = "mm/dd/yyyy")
	private Calendar taskCreatedDate;

	@DateTimeFormat(pattern = "mm/dd/yyyy")
	private Calendar taskStartDate;

	@DateTimeFormat(pattern = "mm/dd/yyyy")
	private Calendar completedDate;

	private Calendar startDate;

	private TasksStatusDto tasksStatusDto;
	private String[] tasks;
	private PriorityStatus priorityStatus;
	private TaskStatus taskStatus;

	/**
	 * @return the startDate
	 */
	public Calendar getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	public Calendar getTaskCreatedDate() {
		return taskCreatedDate;
	}
	/**
	 * @param taskCreatedDate the taskCreatedDate to set
	 */
	public void setTaskCreatedDate(Calendar taskCreatedDate) {
		this.taskCreatedDate = taskCreatedDate;
	}
	/**
	 * @return the taskStartDate
	 */
	
	public Calendar getTaskStartDate() {
		return taskStartDate;
	}
	/**
	 * @param taskStartDate the taskStartDate to set
	 */
	public void setTaskStartDate(Calendar taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public Calendar getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Calendar completedDate) {
		this.completedDate = completedDate;
	}

	public TasksStatusDto getTasksStatusDto() {
		return tasksStatusDto;
	}
	public void setTasksStatusDto(TasksStatusDto tasksStatusDto) {
		this.tasksStatusDto = tasksStatusDto;
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
	
	public PriorityStatus getPriorityStatus() {
		return priorityStatus;
	}
	
	public void setPriorityStatus(PriorityStatus priorityStatus) {
		this.priorityStatus = priorityStatus;
	}
	
	public TaskStatus getTaskStatus() {
		return taskStatus;
	}
	
	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}
	
}
