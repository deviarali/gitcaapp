package com.ajahsma.caapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "UserRole")
@Table(name = "userrole")
public class UserRoleModel extends AbstractIdDomain {

	private String roleName;

	@Column(name = "rolename", nullable = false, length = 45)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}