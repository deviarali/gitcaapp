package com.ajahsma.caapp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class TaskModel extends AbstractIdDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "client_id")
	private ClientModel clientModel;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "nature_of_assignment_id")
	private NatureOfAssignmentModel natureOfAssignmentModel;
	
	@Column(name = "employee_task_remarks")
	private String taskRemarksByEmployee;
	
	@Column(name = "admin_task_remark")
	private String taskRemarksByAdmin;
	
	@Column(name = "verify_by")
	private String taskVerifiedBy;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "task_assignee_id")
	private EmployeeModel employeeModel;
	
	@Column(name = "task_created_date")
	private Date taskCreatedDate;
	
	@Column(name = "task_start_date")
	private Date taskStartDate;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "task_status_id")
	private TasksStatusModel tasksStatusModel;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "prioritystatus", nullable=false)
	private PriorityStatus priorityStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tasktatus", nullable=false)
	private TaskStatus taskStatus;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the clientDto
	 */
	public ClientModel getClientModel() {
		return clientModel;
	}

	/**
	 * @param clientDto the clientDto to set
	 */
	public void setClientModel(ClientModel clientModel) {
		this.clientModel = clientModel;
	}

	/**
	 * @return the natureOfAssignmentDto
	 */
	public NatureOfAssignmentModel getNatureOfAssignmentModel() {
		return natureOfAssignmentModel;
	}

	/**
	 * @param natureOfAssignmentDto the natureOfAssignmentDto to set
	 */
	public void setNatureOfAssignmentModel(NatureOfAssignmentModel natureOfAssignmentModel) {
		this.natureOfAssignmentModel = natureOfAssignmentModel;
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
	public EmployeeModel getTaskAssigneeId() {
		return employeeModel;
	}

	/**
	 * @param taskAssigneeId the taskAssigneeId to set
	 */
	public void setTaskAssigneeId(EmployeeModel employeeModel) {
		this.employeeModel = employeeModel;
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
	public TasksStatusModel getTaskStatusId() {
		return tasksStatusModel;
	}

	/**
	 * @param taskStatusId the taskStatusId to set
	 */
	public void setTaskStatusId(TasksStatusModel tasksStatusModel) {
		this.tasksStatusModel = tasksStatusModel;
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
