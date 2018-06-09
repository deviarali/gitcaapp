package com.ajahsma.caapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "companystatus")
public class CompanyStatusModel extends AbstractIdDomain { 
	
	private String companyStatusName;

	@Column(name = "name")
	public String getCompanyStatusName() {
		return companyStatusName;
	}

	public void setCompanyStatusName(String companyStatusName) {
		this.companyStatusName = companyStatusName;
	}
	
}
