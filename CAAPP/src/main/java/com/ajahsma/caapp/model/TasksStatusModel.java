package com.ajahsma.caapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "taskstatus")
public class TasksStatusModel extends AbstractIdDomain {
	
	private String tasksStatusName;
	
	@Column(name = "name")
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
