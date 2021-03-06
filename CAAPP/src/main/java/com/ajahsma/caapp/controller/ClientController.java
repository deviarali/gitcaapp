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
import org.springframework.util.StringUtils;
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
import com.ajahsma.caapp.model.ClientModel;
import com.ajahsma.caapp.model.NatureOfAssignmentModel;
import com.ajahsma.caapp.service.ClientService;
import com.ajahsma.caapp.service.HomePageService;
import com.ajahsma.caapp.utils.CaAppUtils;
import com.ajahsma.caapp.validator.ClientValidator;
import com.ajahsma.caapp.validator.NatureOfAssignmentValidator;

/**
 * @author Dev
 *
 */

@Controller
@RequestMapping(value = "caapp")
public class ClientController extends BaseController {
	
	private static Logger logger = Logger.getLogger(ClientController.class);
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	ClientValidator clientValidator; 
	
	@Autowired
	NatureOfAssignmentValidator natureOfAssignmentValidator;
	
	@Autowired
	HomePageService homePageService;

	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public String homePage(Model model)
	{
		List<HomePageDto> listOfRecentClients = homePageService.getRecentClients();
		model.addAttribute("recentClients", listOfRecentClients);
		return "client";
	}

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
	public ModelAndView showClient(Model model, @PathVariable("id") Long id)
	{
		List<ClientTypeDto> clientTypeDtos = getClientTypes();
		List<CompanyStatusDto> companyStatusDtos = getCompanyStatus();
		List<NatureOfAssignmentDto> natureOfAssignmentDtos = getNatureOfAssignments();
		model.addAttribute("clientTypeDtos", clientTypeDtos);
		model.addAttribute("companyStatusDtos", companyStatusDtos);
		model.addAttribute("natureOfAssignmentDtos", natureOfAssignmentDtos);
		ClientDto clientDto = clientService.getClientDto(id);
		
		/*return "clientRegistration";*/
		return new ModelAndView("clientRegistration", "clientRegistration", clientDto);
	}
	
	@RequestMapping(value = "/client/delete/{id}", method = RequestMethod.GET)
	public String deleteClient(Model model, @PathVariable("id") Long id, RedirectAttributes redirectAttributes)
	{
		try {
			ClientModel client = (ClientModel) clientService.getDomain(ClientModel.class, id);
			
			clientService.deleteDomain(client);
		} catch (Exception e) {
			model.addAttribute("alert_msg", "Oops! " + e.getMessage());
			redirectAttributes.addFlashAttribute("alert_msg", "Oops! " + e.getMessage());
		}
		
		return "redirect:/caapp/client";
	}
	
	@RequestMapping(value = "/client/clientRegister", method = RequestMethod.POST)
	public ModelAndView clientRegister(@Valid @ModelAttribute("clientRegistration") ClientDto clientDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes)
	{
		clientValidator.validate(clientDto, bindingResult);
		if(bindingResult.hasErrors()) {
			model.addAttribute("alert_msg", "Problem with Client registered");
			model.addAttribute("clientRegistration", clientDto);
		}
		else {
			clientService.clientRegister(clientDto);
			model.addAttribute("clientRegistration", new ClientDto());
			model.addAttribute("alert_msg", "Client registered successfully");
		}
		redirectAttributes.addAttribute("successmsg", "Client registered successfully");
		
		List<ClientTypeDto> clientTypeDtos = getClientTypes();
		List<CompanyStatusDto> companyStatusDtos = getCompanyStatus();
		List<NatureOfAssignmentDto> natureOfAssignmentDtos = getNatureOfAssignments();
		model.addAttribute("clientTypeDtos", clientTypeDtos);
		model.addAttribute("companyStatusDtos", companyStatusDtos);
		model.addAttribute("natureOfAssignmentDtos", natureOfAssignmentDtos);
		
		return new ModelAndView("clientRegistration");
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
	
	@RequestMapping(value = "/natureOfAssignment", method = RequestMethod.GET)
	public ModelAndView navigateToNatureOfAssignmentRegister(Model model) {
		
		List<NatureOfAssignmentDto> natureOfAssignmentDtos = getNatureOfAssignments();
		model.addAttribute("natureOfAssignments", natureOfAssignmentDtos);
//		model.addAttribute("natureOfAssignment", new NatureOfAssignmentDto());
		return new ModelAndView("natureOfAssignment");

	}
	
	@RequestMapping(value = "/natureOfAssignment/createNatureOfAssignment", method = RequestMethod.GET)
	public ModelAndView createNatureOfAssignment(Model model) {
		
		List<NatureOfAssignmentDto> natureOfAssignmentDtos = getNatureOfAssignments();
		model.addAttribute("natureOfAssignments", natureOfAssignmentDtos);
		model.addAttribute("natureOfAssignment", new NatureOfAssignmentDto());
		return new ModelAndView("natureOfAssignmentRegister");

	}
	
	@RequestMapping(value = "/natureOfAssignment/{id}", method = RequestMethod.GET)
	public ModelAndView showNatureOfAssignment(Model model, @PathVariable("id") Long id)
	{
		List<NatureOfAssignmentDto> natureOfAssignmentDtos = getNatureOfAssignments();
		model.addAttribute("natureOfAssignments", natureOfAssignmentDtos);
		NatureOfAssignmentDto natureOfAssignmentDto = clientService.getNatureOfAssignmentDto(id);
		
		model.addAttribute("natureOfAssignment", natureOfAssignmentDto);
		return new ModelAndView("natureOfAssignmentRegister");
	}
	
	@RequestMapping(value = "/natureOfAssignment/delete/{id}", method = RequestMethod.GET)
	public String deleteNatureOfAssignment(Model model, @PathVariable("id") Long id, RedirectAttributes redirectAttributes)
	{
		try {
			NatureOfAssignmentModel natureOfAssignment = (NatureOfAssignmentModel) clientService.getDomain(NatureOfAssignmentModel.class, id);
			
			clientService.deleteDomain(natureOfAssignment);
			model.addAttribute("alert_msg", "Deleted Successfully");
			redirectAttributes.addFlashAttribute("alert_msg", "Deleted Successfully");
			
		} catch (Exception e) {
			model.addAttribute("alert_msg", "Oops! " + e.getMessage());
			redirectAttributes.addFlashAttribute("alert_msg", "Oops! " + e.getMessage());
		}
		
		return "redirect:/caapp/natureOfAssignment";
	}

	@RequestMapping(value = "/natureOfAssignment/natureOfAssignmentRegister", method = RequestMethod.POST)
	public ModelAndView homePage(@Valid @ModelAttribute("natureOfAssignment") NatureOfAssignmentDto natureOfAssignment, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		try {
			natureOfAssignmentValidator.validate(natureOfAssignment, bindingResult);
			if(bindingResult.hasErrors())
			{
				model.addAttribute("natureOfAssignment", natureOfAssignment);
				return new ModelAndView("natureOfAssignmentRegister");
			}
			if(StringUtils.hasText(natureOfAssignment.getNatureOfAssignmentName()) && natureOfAssignment.getNatureOfAssignmentName().contains(" ")) {
				natureOfAssignment.setNatureOfAssignmentName(natureOfAssignment.getNatureOfAssignmentName().toUpperCase().replaceAll(" ", "_"));
			}
			clientService.natureOfAssignmentRegister(natureOfAssignment);

			model.addAttribute("alert_msg", "Nature Of Assignment Register successfully");
		} catch (Exception e) {
			model.addAttribute("natureOfAssignment", natureOfAssignment);
			model.addAttribute("alert_msg", "Oops! " + e.getMessage());
		}
		return new ModelAndView("natureOfAssignmentRegister", "natureOfAssignment", new NatureOfAssignmentDto());

	}
	
	

	
}
