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

import com.ajahsma.caapp.dao.ClientDao;
import com.ajahsma.caapp.dto.ClientDto;
import com.ajahsma.caapp.dto.ClientTypeDto;
import com.ajahsma.caapp.dto.CompanyStatusDto;
import com.ajahsma.caapp.dto.NatureOfAssignmentDto;
import com.ajahsma.caapp.model.ClientModel;
import com.ajahsma.caapp.model.ClientNatureOfAssignmentModel;
import com.ajahsma.caapp.model.ClientTypeModel;
import com.ajahsma.caapp.model.CompanyStatusModel;
import com.ajahsma.caapp.model.NatureOfAssignmentModel;
import com.ajahsma.caapp.service.ClientService;

/**
 * @author Dev
 *
 */
@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao clientDao;
	
	@Override
	public List<ClientTypeDto> getClientTypes() {
		List<ClientTypeModel> clientTypeModels = clientDao.getClientTypes();
		List<ClientTypeDto> clientTypeDtos = new ArrayList<>();
		
		for(ClientTypeModel clientTypeModel : clientTypeModels)
		{
		//	ClientTypeModel clientTypeModel = (ClientTypeModel) object;
			//ClientTypeDto clientTypeDto = CaAppUtils.copyBeanProperties(clientTypeModel, ClientTypeDto.class);
			ClientTypeDto clientTypeDto = new ClientTypeDto();
			clientTypeDto.setClientTypeId(clientTypeModel.getClientTypeId());
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
			companyStatusDto.setCompanyStatusId(companyStatusModel.getCompanyStatusId());
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
			natureOfAssignmentDto.setNatureOfAssignmentId(natureOfAssignmentModel.getNatureOfAssignmentId());
			natureOfAssignmentDto.setNatureOfAssignmentName(natureOfAssignmentModel.getNatureOfAssignmentName());
			natureOfAssignmentDtos.add(natureOfAssignmentDto);
		}
		return natureOfAssignmentDtos;
	}

	@Transactional
	public void clientRegister(ClientDto clientDto) 
	{
		ClientModel clientModel = new ClientModel();
		CompanyStatusModel companyStatusModel = new CompanyStatusModel();
		ClientTypeModel clientTypeModel = new ClientTypeModel();
		clientModel.setClientName(clientDto.getClientName());
		clientModel.setTradeName(clientDto.getTradeName());
		companyStatusModel.setCompanyStatusId(clientDto.getCompanyStatusDto().getCompanyStatusId());
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
		clientTypeModel.setClientTypeId(clientDto.getClientTypeDto().getClientTypeId());
		clientModel.setClientTypeModel(clientTypeModel);	
		
		clientDao.save(clientModel);
		
		/*List<NatureOfAssignmentDto> natureOfAssignmentDtoList = clientDto.getNatureOfAssignmentList();*/
		/*List<NatureOfAssignmentDto> natureOfAssignmentDtoList = null;
		List<NatureOfAssignmentModel> natureOfAssignmentModelList = new ArrayList<>();
		for(NatureOfAssignmentDto natureOfAssignmentDto : natureOfAssignmentDtoList)
		{
			NatureOfAssignmentModel assignmentModel = new NatureOfAssignmentModel();
			assignmentModel.setNatureOfAssignmentId(natureOfAssignmentDto.getNatureOfAssignmentId());
			natureOfAssignmentModelList.add(assignmentModel);
		}*/
		
		String[] natureOfAssignmentList = clientDto.getNatureOfAssignmentList();
		for(String natureOfAssignment : natureOfAssignmentList)
		{
			NatureOfAssignmentModel natureOfAssignmentModel = new NatureOfAssignmentModel();
			ClientNatureOfAssignmentModel clientNatureOfAssignmentModel = new ClientNatureOfAssignmentModel();
			clientNatureOfAssignmentModel.setClientModel(clientModel);
			natureOfAssignmentModel.setNatureOfAssignmentId(Integer.parseInt(natureOfAssignment));
			clientNatureOfAssignmentModel.setNatureOfAssignmentModel(natureOfAssignmentModel);
			clientNatureOfAssignmentModel.setNatureOfAssignmentCreatedDate(new Date());
			clientNatureOfAssignmentModel.setNatureStatus("CREATED");
			
			clientDao.save(clientNatureOfAssignmentModel);
		}
		
		
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

}
