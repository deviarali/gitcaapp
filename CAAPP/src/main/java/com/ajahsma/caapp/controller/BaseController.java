package com.ajahsma.caapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ajahsma.caapp.security.SecurityContextHelper;
import com.ajahsma.caapp.service.EmployeeService;

public class BaseController {

	@Autowired
	private EmployeeService employeeService;
	
	@ModelAttribute("isAdmin")
	private Boolean isAdmin() {
		
		return SecurityContextHelper.isAdmin();
	}
	
	@ModelAttribute("isManager")
	private Boolean isManager() {
		
		return SecurityContextHelper.isManager();
	}
	
	@ModelAttribute("employeeId")
	private Long getEmployeeId() {
		
		return employeeService.getEmployeeFromApplicationUser(SecurityContextHelper.getApplicationUser().getId());
	}
	
}
