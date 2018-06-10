package com.ajahsma.caapp.model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author SHARAN A
 */

@SuppressWarnings("serial")
@Entity(name = "ApplicationUser")
@Table(name = "applicationuser")
public class ApplicationUserModel extends AbstractIdDomain {

	private String userName;
	private String password;
	private Integer loginAttempts;
	private Calendar createDate;
	private Boolean isActive;
	private Set<UserRoleModel> userRoles;

	@Column(name = "username", nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "loginattempts", nullable = false)
	public Integer getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(Integer loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	@Column(name = "createdate", nullable = false)
	public Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	@Column(name = "isactive", nullable = false)
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@ManyToMany(cascade=CascadeType.DETACH, fetch=FetchType.EAGER)
    @JoinTable(name = "userroles", joinColumns = @JoinColumn(name = "applicationuser_id"), inverseJoinColumns = @JoinColumn(name = "userrole_id"))
	public Set<UserRoleModel> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRoleModel> userRoles) {
		this.userRoles = userRoles;
	}
	
	public void addUserRole(UserRoleModel userRole) {
		if(getUserRoles() == null) {
			setUserRoles(new HashSet<UserRoleModel>());
		}
		
		getUserRoles().add(userRole);
	}

}
