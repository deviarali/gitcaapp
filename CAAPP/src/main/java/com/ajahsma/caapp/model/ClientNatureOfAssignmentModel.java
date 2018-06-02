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
@Table(name = "client_nature_of_assignment")
public class ClientNatureOfAssignmentModel extends AbstractIdDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "nature_id")
	private int natureId;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "client_id")
	private ClientModel clientModel;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "nature_of_assignment_id")
	private NatureOfAssignmentModel natureOfAssignmentModel;
	
	@Column(name = "nature_of_assignment_createddate")
	private Date natureOfAssignmentCreatedDate;
	
	@Column(name = "nature_status")
	private String natureStatus;

	/**
	 * @return the natureId
	 */
	public int getNatureId() {
		return natureId;
	}

	/**
	 * @param natureId the natureId to set
	 */
	public void setNatureId(int natureId) {
		this.natureId = natureId;
	}

	/**
	 * @return the clientModel
	 */
	public ClientModel getClientModel() {
		return clientModel;
	}

	/**
	 * @param clientModel the clientModel to set
	 */
	public void setClientModel(ClientModel clientModel) {
		this.clientModel = clientModel;
	}

	/**
	 * @return the natureOfAssignmentModel
	 */
	public NatureOfAssignmentModel getNatureOfAssignmentModel() {
		return natureOfAssignmentModel;
	}

	/**
	 * @param natureOfAssignmentModel the natureOfAssignmentModel to set
	 */
	public void setNatureOfAssignmentModel(NatureOfAssignmentModel natureOfAssignmentModel) {
		this.natureOfAssignmentModel = natureOfAssignmentModel;
	}

	/**
	 * @return the natureOfAssignmentCreatedDate
	 */
	public Date getNatureOfAssignmentCreatedDate() {
		return natureOfAssignmentCreatedDate;
	}

	/**
	 * @param natureOfAssignmentCreatedDate the natureOfAssignmentCreatedDate to set
	 */
	public void setNatureOfAssignmentCreatedDate(Date natureOfAssignmentCreatedDate) {
		this.natureOfAssignmentCreatedDate = natureOfAssignmentCreatedDate;
	}

	/**
	 * @return the natureStatus
	 */
	public String getNatureStatus() {
		return natureStatus;
	}

	/**
	 * @param natureStatus the natureStatus to set
	 */
	public void setNatureStatus(String natureStatus) {
		this.natureStatus = natureStatus;
	}
	
	
}
