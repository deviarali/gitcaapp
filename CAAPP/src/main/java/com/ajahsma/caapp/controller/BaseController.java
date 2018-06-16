package com.ajahsma.caapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ajahsma.caapp.constants.CaAppConstants;
import com.ajahsma.caapp.security.SecurityContextHelper;
import com.ajahsma.caapp.service.EmployeeService;
import com.ajahsma.caapp.service.ParameterService;

public class BaseController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ParameterService parameterService;
	
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
	
	@ModelAttribute("notificationMorque")
	private String getNotificationMorque() {
		String notificationMorqueParameter = parameterService.getParameterValue(CaAppConstants.PARAMETER_NOTIFICATION_MORQUE, String.class);
		
		return notificationMorqueParameter;
	}
	
}
