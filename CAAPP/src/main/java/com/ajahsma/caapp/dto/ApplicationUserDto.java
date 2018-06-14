package com.ajahsma.caapp.dto;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import com.ajahsma.caapp.model.UserRoleModel;

/**
 * @author SHARAN A
 */

public class ApplicationUserDto  {

	private Long id;
	private String userName;
	private String password;
	private Integer loginAttempts;
	private Calendar createDate;
	private Boolean isActive;
	
	private String[] userRoles;

	private Set<UserRoleDto> userRoleDtos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(Integer loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	public Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String[] getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(String[] userRoles) {
		this.userRoles = userRoles;
	}

	public Set<UserRoleDto> getUserRoleDtos() {
		return userRoleDtos;
	}

	public void setUserRoleDtos(Set<UserRoleDto> userRoleDtos) {
		this.userRoleDtos = userRoleDtos;
	}
	
	public void addUserRole(UserRoleDto userRole) {
		if(getUserRoleDtos() == null) {
			setUserRoleDtos(new HashSet<UserRoleDto>());
		}
		
		getUserRoleDtos().add(userRole);
	}
	
}
