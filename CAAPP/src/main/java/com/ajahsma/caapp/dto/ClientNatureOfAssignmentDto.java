package com.ajahsma.caapp.dto;

import com.ajahsma.caapp.model.ClientModel;
import com.ajahsma.caapp.model.NatureOfAssignmentModel;

public class ClientNatureOfAssignmentDto 
{
	private int natureId;
	private ClientModel clientModel;
	private NatureOfAssignmentDto natureOfAssignmentDto;
	private String natureOfAssignmentCreatedDate;
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
	 * @return the natureOfAssignmentDto
	 */
	public NatureOfAssignmentDto getNatureOfAssignmentDto() {
		return natureOfAssignmentDto;
	}
	/**
	 * @param natureOfAssignmentDto the natureOfAssignmentDto to set
	 */
	public void setNatureOfAssignmentDto(NatureOfAssignmentDto natureOfAssignmentDto) {
		this.natureOfAssignmentDto = natureOfAssignmentDto;
	}
	/**
	 * @return the natureOfAssignmentCreatedDate
	 */
	public String getNatureOfAssignmentCreatedDate() {
		return natureOfAssignmentCreatedDate;
	}
	/**
	 * @param natureOfAssignmentCreatedDate the natureOfAssignmentCreatedDate to set
	 */
	public void setNatureOfAssignmentCreatedDate(String natureOfAssignmentCreatedDate) {
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
