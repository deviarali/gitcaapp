/**
 * 
 */
package com.ajahsma.caapp.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Dev
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "client")
public class ClientModel extends AbstractIdDomain { 

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
	private Boolean isActive;
	private Boolean isRecurrent;
	
	private CompanyStatusModel companyStatusModel;
	private ClientTypeModel clientTypeModel;
	
	private Set<NatureOfAssignmentModel> natureOfAssignments;
	
	@Column(name = "clientname")
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Column(name = "tradename")
	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	@Column(name = "mobile")
	public String getClientMobile() {
		return clientMobile;
	}

	public void setClientMobile(String clientMobile) {
		this.clientMobile = clientMobile;
	}

	@Column(name = "email")
	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	@Column(name = "pan")
	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	@Column(name = "aadhar")
	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	@Column(name = "gst")
	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	@Column(name = "tan")
	public String getTanNumber() {
		return tanNumber;
	}

	public void setTanNumber(String tanNumber) {
		this.tanNumber = tanNumber;
	}

	@Column(name = "accountdetails")
	public String getAccountDetails() {
		return accountDetails;
	}

	public void setAccountDetails(String accountDetails) {
		this.accountDetails = accountDetails;
	}

	@Column(name = "esi")
	public String getClientEsi() {
		return clientEsi;
	}

	public void setClientEsi(String clientEsi) {
		this.clientEsi = clientEsi;
	}

	@Column(name = "epf")
	public String getClientEpf() {
		return clientEpf;
	}

	public void setClientEpf(String clientEpf) {
		this.clientEpf = clientEpf;
	}

	@Column(name = "se")
	public String getClientSE() {
		return clientSE;
	}

	public void setClientSE(String clientSE) {
		this.clientSE = clientSE;
	}

	@Column(name = "createddate")
	public Date getClientCreatedDate() {
		return clientCreatedDate;
	}

	public void setClientCreatedDate(Date clientCreatedDate) {
		this.clientCreatedDate = clientCreatedDate;
	}

	@Column(name = "isactive", nullable = false)
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name = "isrecurrent", nullable = false)
	public Boolean getIsRecurrent() {
		return isRecurrent;
	}

	public void setIsRecurrent(Boolean isRecurrent) {
		this.isRecurrent = isRecurrent;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "companystatus_id")
	public CompanyStatusModel getCompanyStatusModel() {
		return companyStatusModel;
	}

	public void setCompanyStatusModel(CompanyStatusModel companyStatusModel) {
		this.companyStatusModel = companyStatusModel;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "clienttype_id")
	public ClientTypeModel getClientTypeModel() {
		return clientTypeModel;
	}

	public void setClientTypeModel(ClientTypeModel clientTypeModel) {
		this.clientTypeModel = clientTypeModel;
	}

	@ManyToMany(cascade=CascadeType.DETACH, fetch=FetchType.EAGER)
    @JoinTable(name = "clientnatureofassignment", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "natureofassignment_id"))
	public Set<NatureOfAssignmentModel> getNatureOfAssignments() {
		return natureOfAssignments;
	}

	public void setNatureOfAssignments(Set<NatureOfAssignmentModel> natureOfAssignments) {
		this.natureOfAssignments = natureOfAssignments;
	}
	
	public void addNatureOfAssignment(NatureOfAssignmentModel natureOfAssignment) {
		if(getNatureOfAssignments() == null) {
			setNatureOfAssignments(new HashSet<NatureOfAssignmentModel>());
		}
		
		getNatureOfAssignments().add(natureOfAssignment);
	}

	
	
}
