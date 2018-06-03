package com.ajahsma.caapp.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.ajahsma.caapp.model.ApplicationUserModel;
import com.ajahsma.caapp.model.UserRoleModel;

@Component("securityContextHelper")
public class SecurityContextHelper {

	public static ApplicationUserModel getApplicationUser() {
		ApplicationUserModel applicationUser = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		applicationUser = (ApplicationUserModel) authentication.getPrincipal();
		
		return applicationUser;
	}
	
	public static Boolean isAdmin() {
		Boolean isAdmin = Boolean.FALSE;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		ApplicationUserModel applicationUser = (ApplicationUserModel) authentication.getPrincipal();
		
		if(applicationUser != null && !CollectionUtils.isEmpty(applicationUser.getUserRoles())) {
			for (UserRoleModel	userRole : applicationUser.getUserRoles()) {
				if("ROLE_ADMIN".equals(userRole.getRoleName())) {
					isAdmin = Boolean.TRUE;
					break;
				}
			}
		}
		
		return isAdmin;
	}
	
}
