package com.ajahsma.caapp.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "tasks")
public class TaskModel extends AbstractIdDomain {

	private ClientModel clientModel;
	private NatureOfAssignmentModel natureOfAssignmentModel;
	private String taskRemarksByEmployee;
	private String taskRemarksByAdmin;
	private String taskVerifiedBy;
	private EmployeeModel employeeModel;
	private Calendar taskCreatedDate;
	private Calendar taskStartDate;
	private Calendar completedDate;
	
//	private TasksStatusModel tasksStatusModel;
	
	private PriorityStatus priorityStatus;
	private TaskStatus taskStatus;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "client_id")
	public ClientModel getClientModel() {
		return clientModel;
	}

	/**
	 * @param clientDto the clientDto to set
	 */
	public void setClientModel(ClientModel clientModel) {
		this.clientModel = clientModel;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "natureofassignment_id")
	public NatureOfAssignmentModel getNatureOfAssignmentModel() {
		return natureOfAssignmentModel;
	}

	/**
	 * @param natureOfAssignmentDto the natureOfAssignmentDto to set
	 */
	public void setNatureOfAssignmentModel(NatureOfAssignmentModel natureOfAssignmentModel) {
		this.natureOfAssignmentModel = natureOfAssignmentModel;
	}

	@Column(name = "employeeremarks")
	public String getTaskRemarksByEmployee() {
		return taskRemarksByEmployee;
	}

	/**
	 * @param taskRemarksByEmployee the taskRemarksByEmployee to set
	 */
	public void setTaskRemarksByEmployee(String taskRemarksByEmployee) {
		this.taskRemarksByEmployee = taskRemarksByEmployee;
	}
	
	@Column(name = "adminremarks")
	public String getTaskRemarksByAdmin() {
		return taskRemarksByAdmin;
	}

	/**
	 * @param taskRemarksByAdmin the taskRemarksByAdmin to set
	 */
	public void setTaskRemarksByAdmin(String taskRemarksByAdmin) {
		this.taskRemarksByAdmin = taskRemarksByAdmin;
	}

	@Column(name = "verifyby")
	public String getTaskVerifiedBy() {
		return taskVerifiedBy;
	}

	/**
	 * @param taskVerifiedBy the taskVerifiedBy to set
	 */
	public void setTaskVerifiedBy(String taskVerifiedBy) {
		this.taskVerifiedBy = taskVerifiedBy;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "employee_id")
	public EmployeeModel getEmployeeModel() {
		return employeeModel;
	}

	/**
	 * @param taskAssigneeId the taskAssigneeId to set
	 */
	public void setEmployeeModel(EmployeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}

	@Column(name = "createddate")
	public Calendar getTaskCreatedDate() {
		return taskCreatedDate;
	}

	/**
	 * @param taskCreatedDate the taskCreatedDate to set
	 */
	public void setTaskCreatedDate(Calendar taskCreatedDate) {
		this.taskCreatedDate = taskCreatedDate;
	}

	@Column(name = "startdate")
	public Calendar getTaskStartDate() {
		return taskStartDate;
	}

	/**
	 * @param taskStartDate the taskStartDate to set
	 */
	public void setTaskStartDate(Calendar taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	
	@Column(name = "completeddate", nullable = true)
	public Calendar getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Calendar completedDate) {
		this.completedDate = completedDate;
	}

	/*@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "taskstatus_id")
	public TasksStatusModel getTasksStatusModel() {
		return tasksStatusModel;
	}

	*//**
	 * @param taskStatusId the taskStatusId to set
	 *//*
	public void setTasksStatusModel(TasksStatusModel tasksStatusModel) {
		this.tasksStatusModel = tasksStatusModel;
	}*/
	
	@Enumerated(EnumType.STRING)
	@Column(name = "prioritystatus", nullable=false)
	public PriorityStatus getPriorityStatus() {
		return priorityStatus;
	}
	
	public void setPriorityStatus(PriorityStatus priorityStatus) {
		this.priorityStatus = priorityStatus;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tasktatus", nullable=false)
	public TaskStatus getTaskStatus() {
		return taskStatus;
	}
	
	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}
	
}
