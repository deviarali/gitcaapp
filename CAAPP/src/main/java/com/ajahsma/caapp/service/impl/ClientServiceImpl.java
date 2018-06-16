/**
 * 
 */
package com.ajahsma.caapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ajahsma.caapp.dao.ClientDao;
import com.ajahsma.caapp.dto.ClientDto;
import com.ajahsma.caapp.dto.ClientTypeDto;
import com.ajahsma.caapp.dto.CompanyStatusDto;
import com.ajahsma.caapp.dto.NatureOfAssignmentDto;
import com.ajahsma.caapp.model.ClientModel;
import com.ajahsma.caapp.model.ClientTypeModel;
import com.ajahsma.caapp.model.CompanyStatusModel;
import com.ajahsma.caapp.model.NatureOfAssignmentModel;
import com.ajahsma.caapp.service.ClientService;

/**
 * @author Dev
 *
 */
@Service
public class ClientServiceImpl extends DefaultManagerImpl implements ClientService {

	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	public void setDefaultDao(ClientDao defaultDao) {
		this.defaultDao = defaultDao;
	}

	private ClientDao getClientDao() {
		return (ClientDao) getDefaultDao();
	}
	
	@Override
	public List<ClientTypeDto> getClientTypes() {
		List<ClientTypeModel> clientTypeModels = clientDao.getClientTypes();
		List<ClientTypeDto> clientTypeDtos = new ArrayList<>();
		
		for(ClientTypeModel clientTypeModel : clientTypeModels)
		{
		//	ClientTypeModel clientTypeModel = (ClientTypeModel) object;
			//ClientTypeDto clientTypeDto = CaAppUtils.copyBeanProperties(clientTypeModel, ClientTypeDto.class);
			ClientTypeDto clientTypeDto = new ClientTypeDto();
			clientTypeDto.setClientTypeId(clientTypeModel.getId());
			clientTypeDto.setClientTypeName(clientTypeModel.getClientTypeName());
			clientTypeDtos.add(clientTypeDto);
		}
		return clientTypeDtos;
	}

	@Override
	public List<CompanyStatusDto> getCompanyStatus() {
		List<CompanyStatusModel> companyStatusModels = clientDao.getCompanyStatus();
		List<CompanyStatusDto> companyStatusDtos = new ArrayList<>();
		for(CompanyStatusModel companyStatusModel : companyStatusModels)
		{
			//CompanyStatusDto companyStatusDto = CaAppUtils.copyBeanProperties(companyStatusModel, CompanyStatusDto.class);
			CompanyStatusDto companyStatusDto = new CompanyStatusDto();
			companyStatusDto.setCompanyStatusId(companyStatusModel.getId());
			companyStatusDto.setCompanyStatusName(companyStatusModel.getCompanyStatusName());
			companyStatusDtos.add(companyStatusDto);
		}
		return companyStatusDtos;
	}

	@Override
	public List<NatureOfAssignmentDto> getNatureOfAssignments() {
		List<NatureOfAssignmentModel> natureOfAssignmentModels = clientDao.getNatureOfAssignments();
		List<NatureOfAssignmentDto> natureOfAssignmentDtos = new ArrayList<>();
		for(NatureOfAssignmentModel natureOfAssignmentModel : natureOfAssignmentModels)
		{
			//NatureOfAssignmentDto natureOfAssignmentDto = CaAppUtils.copyBeanProperties(natureOfAssignmentModel, NatureOfAssignmentDto.class);
			NatureOfAssignmentDto natureOfAssignmentDto = new NatureOfAssignmentDto();
			natureOfAssignmentDto.setNatureOfAssignmentId(natureOfAssignmentModel.getId());
			natureOfAssignmentDto.setNatureOfAssignmentName(natureOfAssignmentModel.getNatureOfAssignmentName());
			natureOfAssignmentDto.setDescription(natureOfAssignmentModel.getDescription());
			natureOfAssignmentDtos.add(natureOfAssignmentDto);
		}
		return natureOfAssignmentDtos;
	}

	@Transactional
	public void clientRegister(ClientDto clientDto) 
	{
		ClientModel clientModel = convertClientDtoToClientModel(clientDto);
		if(clientModel.getId() == null) {
			this.saveDomain(clientModel);
		}
		else {
			this.updateDomain(clientModel);
		}
		
	}
	
	@Transactional
	public void updateClient(ClientDto clientDto) {
		
		ClientModel clientModel = convertClientDtoToClientModel(clientDto);
		
		this.updateDomain(clientModel);
		
	}
	
	@Override
	public ClientDto getClientDto(Long id) {
		
		ClientModel client = (ClientModel) this.getDomain(ClientModel.class, id);
		
		ClientDto clientDto = convertClientModelToClientDto(client);
		
		return clientDto;
	}

	private ClientDto convertClientModelToClientDto(ClientModel client) {
		
		ClientDto clientDto = new ClientDto();
		clientDto.setClientId(client.getId());
		clientDto.setClientName(client.getClientName());
		clientDto.setTradeName(client.getTradeName());
		CompanyStatusDto companyStatusDto = new CompanyStatusDto();
		companyStatusDto.setCompanyStatusId(client.getCompanyStatusModel().getId());
		companyStatusDto.setCompanyStatusName(client.getCompanyStatusModel().getCompanyStatusName());
		clientDto.setCompanyStatusDto(companyStatusDto);
		clientDto.setClientMobile(client.getClientMobile());
		clientDto.setClientEmail(client.getClientEmail());
		clientDto.setPanNumber(client.getPanNumber());
		clientDto.setAadharNumber(client.getAadharNumber());
		clientDto.setGstNumber(client.getGstNumber());
		clientDto.setTanNumber(client.getTanNumber());
		clientDto.setAccountDetails(client.getAccountDetails());
		clientDto.setClientEsi(client.getClientEsi());
		clientDto.setClientEpf(client.getClientEpf());
		clientDto.setClientSE(client.getClientSE());
		clientDto.setClientCreatedDate(new Date());
		clientDto.setIsActive(client.getIsActive());
		clientDto.setIsRecurrent(client.getIsRecurrent());

		ClientTypeDto clientTypeDto = new ClientTypeDto();
		clientTypeDto.setClientTypeId(client.getClientTypeModel().getId());
		clientTypeDto.setClientTypeName(client.getClientTypeModel().getClientTypeName());
		clientDto.setClientTypeDto(clientTypeDto);	
		
		if(!CollectionUtils.isEmpty(client.getNatureOfAssignments())) {
			String[] natureOfAssignmentList = new String[client.getNatureOfAssignments().size()];
			int index = 0;
			for (NatureOfAssignmentModel natureOfAssignment : client.getNatureOfAssignments()) {
				natureOfAssignmentList[index] = natureOfAssignment.getId().toString();
				index++;
			}
			clientDto.setNatureOfAssignmentList(natureOfAssignmentList);
			
		}
		
		return clientDto;
	}

	private ClientModel convertClientDtoToClientModel(ClientDto clientDto) {

		ClientModel clientModel = new ClientModel();
		clientModel.setId(clientDto.getClientId());
		clientModel.setClientName(clientDto.getClientName());
		clientModel.setTradeName(clientDto.getTradeName());

		CompanyStatusModel companyStatusModel = new CompanyStatusModel();
		companyStatusModel.setId(clientDto.getCompanyStatusDto().getCompanyStatusId());
		clientModel.setCompanyStatusModel(companyStatusModel);
		
		clientModel.setClientMobile(clientDto.getClientMobile());
		clientModel.setClientEmail(clientDto.getClientEmail());
		clientModel.setPanNumber(clientDto.getPanNumber());
		clientModel.setAadharNumber(clientDto.getAadharNumber());
		clientModel.setGstNumber(clientDto.getGstNumber());
		clientModel.setTanNumber(clientDto.getTanNumber());
		clientModel.setAccountDetails(clientDto.getAccountDetails());
		clientModel.setClientEsi(clientDto.getClientEsi());
		clientModel.setClientEpf(clientDto.getClientEpf());
		clientModel.setClientSE(clientDto.getClientSE());
		clientModel.setClientCreatedDate(new Date());
		clientModel.setIsActive(clientDto.getIsActive());
		clientModel.setIsRecurrent(clientDto.getIsRecurrent());

		ClientTypeModel clientTypeModel = new ClientTypeModel();
		clientTypeModel.setId(clientDto.getClientTypeDto().getClientTypeId());
		clientModel.setClientTypeModel(clientTypeModel);
		
		String[] natureOfAssignmentList = clientDto.getNatureOfAssignmentList();
		for(String natureOfAssignment : natureOfAssignmentList)
		{
			NatureOfAssignmentModel natureOfAssignmentModel = new NatureOfAssignmentModel();
			natureOfAssignmentModel.setId(Long.parseLong(natureOfAssignment));
			clientModel.addNatureOfAssignment(natureOfAssignmentModel);
			
		}
		
		return clientModel;
	}

	@Override
	public List<ClientModel> getRecentClients() {
		return clientDao.getRecentClients();
	}

	@Override
	public List<ClientModel> getAllClients() {
		List<ClientModel> clientsList = clientDao.getAllClients();
		return clientsList;
	}

	@Override
	public void natureOfAssignmentRegister(NatureOfAssignmentDto natureOfAssignment) {
		NatureOfAssignmentModel natureOfAssignmentModel = new NatureOfAssignmentModel();
		natureOfAssignmentModel.setId(natureOfAssignment.getNatureOfAssignmentId());
		natureOfAssignmentModel.setNatureOfAssignmentName(natureOfAssignment.getNatureOfAssignmentName());
		natureOfAssignmentModel.setDescription(natureOfAssignment.getDescription());

		if(natureOfAssignmentModel.getId() == null) {
			this.saveDomain(natureOfAssignmentModel);
		}
		else {
			this.updateDomain(natureOfAssignmentModel);
		}		
	}

	@Override
	public NatureOfAssignmentDto getNatureOfAssignmentDto(Long id) {
		NatureOfAssignmentModel natureOfAssignment = (NatureOfAssignmentModel) this.getDomain(NatureOfAssignmentModel.class, id);
		NatureOfAssignmentDto natureOfAssignmentDto = new NatureOfAssignmentDto();
		natureOfAssignmentDto.setNatureOfAssignmentId(natureOfAssignment.getId());
		natureOfAssignmentDto.setNatureOfAssignmentName(natureOfAssignment.getNatureOfAssignmentName());
		natureOfAssignmentDto.setDescription(natureOfAssignment.getDescription());

		return natureOfAssignmentDto;
	}

}
