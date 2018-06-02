package com.ajahsma.caapp.model;

public enum TaskStatus {

	ASSIGNED("Assigned"), 
	RE_ASSIGNED("Re Assigned"), 
	IN_PROGRESS("In Progress"),
	PARTIALLY_COMPLETED("Partially Completed"),
	COMPLETED("Completed");

	private String name;

	private TaskStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
