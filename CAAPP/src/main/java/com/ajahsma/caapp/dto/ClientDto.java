/**
 * 
 */
package com.ajahsma.caapp.dto;

import java.util.Date;

/**
 * @author Dev
 *
 */

public class ClientDto 
{
	private int clientId;
	
	private String clientName;
	
	private String tradeName;
	
	private String clientMobile;
	
	private String clientEmail;
	
	private String panNumber;
	
	private String aadharNumber;
	
	private String gstNumber;
	
	private String tanNumber;
	
	private String accountDetails;
	
	private String clientEsi;
	
	private String clientEpf;
	
	private String clientSE;
	
	private Date clientCreatedDate;
	
	private CompanyStatusDto companyStatusDto;
	
	private ClientTypeDto clientTypeDto;
	
	private String[] natureOfAssignmentList;
	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getClientMobile() {
		return clientMobile;
	}

	public void setClientMobile(String clientMobile) {
		this.clientMobile = clientMobile;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getTanNumber() {
		return tanNumber;
	}

	public void setTanNumber(String tanNumber) {
		this.tanNumber = tanNumber;
	}

	public String getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(String accountDetails) {
		this.accountDetails = accountDetails;
	}

	public String getClientEsi() {
		return clientEsi;
	}

	public void setClientEsi(String clientEsi) {
		this.clientEsi = clientEsi;
	}

	public String getClientEpf() {
		return clientEpf;
	}

	public void setClientEpf(String clientEpf) {
		this.clientEpf = clientEpf;
	}

	public String getClientSE() {
		return clientSE;
	}

	public void setClientSE(String clientSE) {
		this.clientSE = clientSE;
	}

	public Date getClientCreatedDate() {
		return clientCreatedDate;
	}

	public void setClientCreatedDate(Date clientCreatedDate) {
		this.clientCreatedDate = clientCreatedDate;
	}

	public CompanyStatusDto getCompanyStatusDto() {
		return companyStatusDto;
	}

	public void setCompanyStatusDto(CompanyStatusDto companyStatusDto) {
		this.companyStatusDto = companyStatusDto;
	}

	public ClientTypeDto getClientTypeDto() {
		return clientTypeDto;
	}

	public void setClientTypeDto(ClientTypeDto clientTypeModel) {
		this.clientTypeDto = clientTypeModel;
	}


	/**
	 * @return the natureOfAssignmentList
	 */
	public String[] getNatureOfAssignmentList() {
		return natureOfAssignmentList;
	}

	/**
	 * @param natureOfAssignmentList the natureOfAssignmentList to set
	 */
	public void setNatureOfAssignmentList(String[] natureOfAssignmentList) {
		this.natureOfAssignmentList = natureOfAssignmentList;
	}


	
}
