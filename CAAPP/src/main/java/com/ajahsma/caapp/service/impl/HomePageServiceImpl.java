/**
 * 
 */
package com.ajahsma.caapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajahsma.caapp.dto.HomePageDto;
import com.ajahsma.caapp.model.ClientModel;
import com.ajahsma.caapp.service.ClientService;
import com.ajahsma.caapp.service.HomePageService;

/**
 * @author Dev
 *
 */

@Service
public class HomePageServiceImpl implements HomePageService{

	@Autowired
	ClientService clientService;
	
	@Override
	public List<HomePageDto> getRecentClients() {
		 List<ClientModel> recentClients = clientService.getRecentClients();
		 List<HomePageDto> recentClientsDtoList = new ArrayList<HomePageDto>();
		 for(ClientModel clientModel : recentClients)
		 {
			 HomePageDto homePageDto = new HomePageDto();
			 homePageDto.setClientId(clientModel.getId());
			 homePageDto.setCustName(clientModel.getClientName());
			 homePageDto.setCompanyStatus(clientModel.getCompanyStatusModel().getCompanyStatusName());
			 homePageDto.setCustCreatedDate(clientModel.getClientCreatedDate());
			 recentClientsDtoList.add(homePageDto);
		 }
		 return recentClientsDtoList;
	}

}
