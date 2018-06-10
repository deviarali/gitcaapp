package com.ajahsma.caapp.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class HomePageDto {
	
	private Long clientId;
	private String custName;
	private String companyStatus;
	
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	private Date custCreatedDate;

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	
	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * @return the companyStatus
	 */
	public String getCompanyStatus() {
		return companyStatus;
	}

	/**
	 * @param companyStatus the companyStatus to set
	 */
	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
	}

	/**
	 * @return the custCreatedDate
	 */
	public Date getCustCreatedDate() {
		return custCreatedDate;
	}

	/**
	 * @param custCreatedDate the custCreatedDate to set
	 */
	public void setCustCreatedDate(Date custCreatedDate) {
		this.custCreatedDate = custCreatedDate;
	}

	
	
}
