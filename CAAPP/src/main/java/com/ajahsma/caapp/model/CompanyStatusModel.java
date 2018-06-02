package com.ajahsma.caapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company_status")
public class CompanyStatusModel extends AbstractIdDomain { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_status_id") 
	private int companyStatusId;
	
	@Column(name = "company_status_name")
	private String companyStatusName;

	public int getCompanyStatusId() {
		return companyStatusId;
	}

	public void setCompanyStatusId(int companyStatusId) {
		this.companyStatusId = companyStatusId;
	}
	
	public String getCompanyStatusName() {
		return companyStatusName;
	}

	public void setCompanyStatusName(String companyStatusName) {
		this.companyStatusName = companyStatusName;
	}
	
	
	
	
}
