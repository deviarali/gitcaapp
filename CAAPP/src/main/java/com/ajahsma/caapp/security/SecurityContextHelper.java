package com.ajahsma.caapp.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.ajahsma.caapp.model.ApplicationUserModel;

@Component("securityContextHelper")
public class SecurityContextHelper {

	public static ApplicationUserModel getApplicationUser() {
		ApplicationUserModel applicationUser = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		applicationUser = (ApplicationUserModel) authentication.getPrincipal();
		
		return applicationUser;
	}
	
}
