/**
 * 
 */
package com.ajahsma.caapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ajahsma.caapp.dto.ClientTypeDto;
import com.ajahsma.caapp.dto.CompanyStatusDto;
import com.ajahsma.caapp.dto.HomePageDto;
import com.ajahsma.caapp.dto.NatureOfAssignmentDto;
import com.ajahsma.caapp.model.ClientTypeModel;
import com.ajahsma.caapp.service.HomePageService;

/**
 * @author Dev
 *
 */

@Controller
@RequestMapping(value = "/caapp/")
public class HomePageController 
{
	@Autowired
	HomePageService homePageService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model)
	{
		List<HomePageDto> listOfRecentClients = homePageService.getRecentClients();
		model.addAttribute("recentClients", listOfRecentClients);
		return "homePage";
	}
}
