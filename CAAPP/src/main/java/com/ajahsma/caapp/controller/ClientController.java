/**
 * 
 */
package com.ajahsma.caapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ajahsma.caapp.dto.ClientDto;
import com.ajahsma.caapp.dto.ClientTypeDto;
import com.ajahsma.caapp.dto.CompanyStatusDto;
import com.ajahsma.caapp.dto.HomePageDto;
import com.ajahsma.caapp.dto.NatureOfAssignmentDto;
import com.ajahsma.caapp.service.ClientService;
import com.ajahsma.caapp.utils.CaAppUtils;
import com.ajahsma.caapp.validator.ClientValidator;

/**
 * @author Dev
 *
 */

@Controller
@RequestMapping(value = "caapp")
public class ClientController 
{
	private static Logger logger = Logger.getLogger(ClientController.class);
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	ClientValidator clientValidator; 
	
	@RequestMapping(value = "/client/clientRegistrationView", method = RequestMethod.GET)
	public ModelAndView clientRegistrationView(Model model)
	{
		List<ClientTypeDto> clientTypeDtos = getClientTypes();
		List<CompanyStatusDto> companyStatusDtos = getCompanyStatus();
		List<NatureOfAssignmentDto> natureOfAssignmentDtos = getNatureOfAssignments();
		model.addAttribute("clientTypeDtos", clientTypeDtos);
		model.addAttribute("companyStatusDtos", companyStatusDtos);
		model.addAttribute("natureOfAssignmentDtos", natureOfAssignmentDtos);
		ClientDto clientDto = new ClientDto();
		
		/*return "clientRegistration";*/
		return new ModelAndView("clientRegistration", "clientRegistration", clientDto);
	}
	
	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
	public ModelAndView showClient(Model model, @PathVariable("id") Integer id)
	{
		List<ClientTypeDto> clientTypeDtos = getClientTypes();
		List<CompanyStatusDto> companyStatusDtos = getCompanyStatus();
		List<NatureOfAssignmentDto> natureOfAssignmentDtos = getNatureOfAssignments();
		model.addAttribute("clientTypeDtos", clientTypeDtos);
		model.addAttribute("companyStatusDtos", companyStatusDtos);
		model.addAttribute("natureOfAssignmentDtos", natureOfAssignmentDtos);
		ClientDto clientDto = new ClientDto();
		
		/*return "clientRegistration";*/
		return new ModelAndView("clientRegistration", "clientRegistration", clientDto);
	}
	
	@RequestMapping(value = "/client/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteClient(Model model, @PathVariable("id") Integer id)
	{
//		List<HomePageDto> listOfRecentClients = homePageService.getRecentClients();
//		model.addAttribute("recentClients", listOfRecentClients);
//		return "homePage";
		
		List<ClientTypeDto> clientTypeDtos = getClientTypes();
		List<CompanyStatusDto> companyStatusDtos = getCompanyStatus();
		List<NatureOfAssignmentDto> natureOfAssignmentDtos = getNatureOfAssignments();
		model.addAttribute("clientTypeDtos", clientTypeDtos);
		model.addAttribute("companyStatusDtos", companyStatusDtos);
		model.addAttribute("natureOfAssignmentDtos", natureOfAssignmentDtos);
		ClientDto clientDto = new ClientDto();
		
		/*return "clientRegistration";*/
		return new ModelAndView("clientRegistration", "clientRegistration", clientDto);
	}
	
	@RequestMapping(value = "/client/clientRegister", method = RequestMethod.POST)
	public ModelAndView clientRegister(@Valid @ModelAttribute("clientRegistration") ClientDto clientDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes)
	{
		clientValidator.validate(clientDto, bindingResult);
		if(!bindingResult.hasErrors()) {
			clientService.clientRegister(clientDto);
		}
		redirectAttributes.addAttribute("successmsg", "Client registered successfully");
		
		List<ClientTypeDto> clientTypeDtos = getClientTypes();
		List<CompanyStatusDto> companyStatusDtos = getCompanyStatus();
		List<NatureOfAssignmentDto> natureOfAssignmentDtos = getNatureOfAssignments();
		model.addAttribute("clientTypeDtos", clientTypeDtos);
		model.addAttribute("companyStatusDtos", companyStatusDtos);
		model.addAttribute("natureOfAssignmentDtos", natureOfAssignmentDtos);
		
		return new ModelAndView("clientRegistration", "clientRegistration", clientDto);
	}

	public List<ClientTypeDto> getClientTypes() {
		List<ClientTypeDto> clientTypeDtos = clientService.getClientTypes();
		if(CaAppUtils.isListNotNullAndEmpty(clientTypeDtos))
		{
			logger.warn("Client type list is empty");
		}
		return clientTypeDtos;
	}

	public List<CompanyStatusDto> getCompanyStatus() {
		List<CompanyStatusDto> companyStatusDtos = clientService.getCompanyStatus();
		if(CaAppUtils.isListNotNullAndEmpty(companyStatusDtos))
		{
			logger.warn("Company staus list is empty");
		}
		return companyStatusDtos;
	}

	public List<NatureOfAssignmentDto> getNatureOfAssignments() {
		List<NatureOfAssignmentDto> natureOfAssignmentDtos = clientService.getNatureOfAssignments();
		if(CaAppUtils.isListNotNullAndEmpty(natureOfAssignmentDtos))
		{
			logger.warn("nature of assignments list is empty");
		}
		return natureOfAssignmentDtos;
	}
	
	
}
