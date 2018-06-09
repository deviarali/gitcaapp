package com.ajahsma.caapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "natureofassignment")
public class NatureOfAssignmentModel extends AbstractIdDomain {
	
	private String natureOfAssignmentName;

	@Column(name = "name")
	public String getNatureOfAssignmentName() {
		return natureOfAssignmentName;
	}

	public void setNatureOfAssignmentName(String natureOfAssignmentName) {
		this.natureOfAssignmentName = natureOfAssignmentName;
	}
	
}
