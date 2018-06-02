package com.ajahsma.caapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nature_of_assignment")
public class NatureOfAssignmentModel extends AbstractIdDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nature_of_assignment_id")
	private int natureOfAssignmentId;
	
	@Column(name = "nature_of_assignment_name")
	private String natureOfAssignmentName;

	/**
	 * @return the natureOfAssignmentId
	 */
	public int getNatureOfAssignmentId() {
		return natureOfAssignmentId;
	}

	/**
	 * @param natureOfAssignmentId the natureOfAssignmentId to set
	 */
	public void setNatureOfAssignmentId(int natureOfAssignmentId) {
		this.natureOfAssignmentId = natureOfAssignmentId;
	}
	
	/**
	 * @return the natureOfAssignmentName
	 */
	public String getNatureOfAssignmentName() {
		return natureOfAssignmentName;
	}

	/**
	 * @param natureOfAssignmentName the natureOfAssignmentName to set
	 */
	public void setNatureOfAssignmentName(String natureOfAssignmentName) {
		this.natureOfAssignmentName = natureOfAssignmentName;
	}
	
	
	
}
