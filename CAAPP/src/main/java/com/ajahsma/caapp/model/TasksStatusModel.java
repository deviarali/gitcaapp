package com.ajahsma.caapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_status")
public class TasksStatusModel extends AbstractIdDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_status_id")
	private int id;
	

	@Column(name = "task_status_name")
	private String tasksStatusName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
