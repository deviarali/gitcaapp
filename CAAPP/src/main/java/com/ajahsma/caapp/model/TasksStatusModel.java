package com.ajahsma.caapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_status")
public class TasksStatusModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_status_id")
	private int tasksStatusId;
	
	@Column(name = "task_status_name")
	private String tasksStatusName;
	/**
	 * @return the tasksStatusId
	 */
	public int getTasksStatusId() {
		return tasksStatusId;
	}
	/**
	 * @param tasksStatusId the tasksStatusId to set
	 */
	public void setTasksStatusId(int tasksStatusId) {
		this.tasksStatusId = tasksStatusId;
	}
	/**
	 * @return the tasksStatusName
	 */
	public String getTasksStatusName() {
		return tasksStatusName;
	}
	/**
	 * @param tasksStatusName the tasksStatusName to set
	 */
	public void setTasksStatusName(String tasksStatusName) {
		this.tasksStatusName = tasksStatusName;
	}
	
	
}
