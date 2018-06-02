package com.ajahsma.caapp.model;

public enum PriorityStatus {

	HIGH("High"), 
	LOW("Low"), 
	EMERGENCY("Emergency");

	private String name;

	private PriorityStatus(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
