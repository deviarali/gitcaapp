/**
 * 
 */
package com.ajahsma.caapp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Dev
 *
 */

@Entity
@Table(name = "client")
public class ClientModel extends AbstractIdDomain { 

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_id")
	private Integer clientId;
	
	@Column(name = "client_name")
	private String clientName;
	
	@Column(name = "trade_name")
	private String tradeName;
	
	@Column(name = "client_mobile")
	private String clientMobile;
	
	@Column(name = "client_email")
	private String clientEmail;
	
	@Column(name = "pan_number")
	private String panNumber;
	
	@Column(name = "aadhar_number")
	private String aadharNumber;
	
	@Column(name = "gst_number")
	private String gstNumber;
	
	@Column(name = "tan_number")
	private String tanNumber;
	
	@Column(name = "account_details")
	private String accountDetails;
	
	@Column(name = "client_esi")
	private String clientEsi;
	
	@Column(name = "client_epf")
	private String clientEpf;
	
	@Column(name = "client_se")
	private String clientSE;
	
	@Column(name = "client_created_date")
	private Date clientCreatedDate;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "company_status_id")
	private CompanyStatusModel companyStatusModel;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "client_type_id")
	private ClientTypeModel clientTypeModel;
	
	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
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

	public CompanyStatusModel getCompanyStatusModel() {
		return companyStatusModel;
	}

	public void setCompanyStatusModel(CompanyStatusModel companyStatusModel) {
		this.companyStatusModel = companyStatusModel;
	}

	public ClientTypeModel getClientTypeModel() {
		return clientTypeModel;
	}

	public void setClientTypeModel(ClientTypeModel clientTypeModel) {
		this.clientTypeModel = clientTypeModel;
	}
}
