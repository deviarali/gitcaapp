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

import com.ajahsma.caapp.dto.HomePageDto;
import com.ajahsma.caapp.service.EmployeeService;
import com.ajahsma.caapp.service.HomePageService;

/**
 * @author Dev
 *
 */

@Controller
@RequestMapping(value = "/caapp")
public class HomePageController extends BaseController {
	
	@Autowired
	HomePageService homePageService;
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(Model model)
	{
		List<HomePageDto> listOfRecentClients = homePageService.getRecentClients();
		model.addAttribute("recentClients", listOfRecentClients);
		return "homePage";
	}
	
}
