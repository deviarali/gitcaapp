package com.ajahsma.caapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "natureofassignment")
public class NatureOfAssignmentModel extends AbstractIdDomain {
	
	private String natureOfAssignmentName;
	private String description;

	@Column(name = "name", nullable = false)
	public String getNatureOfAssignmentName() {
		return natureOfAssignmentName;
	}

	public void setNatureOfAssignmentName(String natureOfAssignmentName) {
		this.natureOfAssignmentName = natureOfAssignmentName;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
