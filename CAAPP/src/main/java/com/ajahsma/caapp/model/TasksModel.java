package com.ajahsma.caapp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class TasksModel extends AbstractIdDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private int id;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClientModel getClientModel() {
		return clientModel;
	}

	public void setClientModel(ClientModel clientModel) {
		this.clientModel = clientModel;
	}

	public NatureOfAssignmentModel getNatureOfAssignmentModel() {
		return natureOfAssignmentModel;
	}

	public void setNatureOfAssignmentModel(NatureOfAssignmentModel natureOfAssignmentModel) {
		this.natureOfAssignmentModel = natureOfAssignmentModel;
	}

	public String getTaskRemarksByEmployee() {
		return taskRemarksByEmployee;
	}

	public void setTaskRemarksByEmployee(String taskRemarksByEmployee) {
		this.taskRemarksByEmployee = taskRemarksByEmployee;
	}

	public String getTaskRemarksByAdmin() {
		return taskRemarksByAdmin;
	}

	public void setTaskRemarksByAdmin(String taskRemarksByAdmin) {
		this.taskRemarksByAdmin = taskRemarksByAdmin;
	}

	public String getTaskVerifiedBy() {
		return taskVerifiedBy;
	}

	public void setTaskVerifiedBy(String taskVerifiedBy) {
		this.taskVerifiedBy = taskVerifiedBy;
	}

	public EmployeeModel getEmployeeModel() {
		return employeeModel;
	}

	public void setEmployeeModel(EmployeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}

	public Date getTaskCreatedDate() {
		return taskCreatedDate;
	}

	public void setTaskCreatedDate(Date taskCreatedDate) {
		this.taskCreatedDate = taskCreatedDate;
	}

	public Date getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public TasksStatusModel getTasksStatusModel() {
		return tasksStatusModel;
	}

	public void setTasksStatusModel(TasksStatusModel tasksStatusModel) {
		this.tasksStatusModel = tasksStatusModel;
	}

		
}
