/**
 * 
 */
package com.ajahsma.caapp.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Dev
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "clientnatureofassignment")
public class ClientNatureOfAssignmentModel extends AbstractIdDomain {
	
	private ClientModel clientModel;
	private NatureOfAssignmentModel natureOfAssignmentModel;
	private Date natureOfAssignmentCreatedDate;
	private String natureStatus;

	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "client_id")
	public ClientModel getClientModel() {
		return clientModel;
	}

	public void setClientModel(ClientModel clientModel) {
		this.clientModel = clientModel;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "natureofassignment_id")
	public NatureOfAssignmentModel getNatureOfAssignmentModel() {
		return natureOfAssignmentModel;
	}

	/**
	 * @param natureOfAssignmentModel the natureOfAssignmentModel to set
	 */
	public void setNatureOfAssignmentModel(NatureOfAssignmentModel natureOfAssignmentModel) {
		this.natureOfAssignmentModel = natureOfAssignmentModel;
	}

	@Column(name = "createddate")
	public Date getNatureOfAssignmentCreatedDate() {
		return natureOfAssignmentCreatedDate;
	}

	public void setNatureOfAssignmentCreatedDate(Date natureOfAssignmentCreatedDate) {
		this.natureOfAssignmentCreatedDate = natureOfAssignmentCreatedDate;
	}

	@Column(name = "status")
	public String getNatureStatus() {
		return natureStatus;
	}

	public void setNatureStatus(String natureStatus) {
		this.natureStatus = natureStatus;
	}
	
	
}
