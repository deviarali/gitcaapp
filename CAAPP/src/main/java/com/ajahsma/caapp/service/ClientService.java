/**
 * 
 */
package com.ajahsma.caapp.service;

import java.util.List;

import com.ajahsma.caapp.dto.ClientDto;
import com.ajahsma.caapp.dto.ClientTypeDto;
import com.ajahsma.caapp.dto.CompanyStatusDto;
import com.ajahsma.caapp.dto.NatureOfAssignmentDto;
import com.ajahsma.caapp.model.ClientModel;

/**
 * @author Dev
 * @param <E>
 *
 */
public interface ClientService extends DefaultManager {

	List<ClientTypeDto> getClientTypes();

	List<CompanyStatusDto> getCompanyStatus();

	List<NatureOfAssignmentDto> getNatureOfAssignments();

	public NatureOfAssignmentDto getNatureOfAssignmentDto(Long id);

	void clientRegister(ClientDto clientDto);
	
	public void updateClient(ClientDto clientDto);

	List<ClientModel> getRecentClients();

	List<ClientModel> getAllClients();
	
	public ClientDto getClientDto(Long id);

	public void natureOfAssignmentRegister(NatureOfAssignmentDto natureOfAssignment);

}
