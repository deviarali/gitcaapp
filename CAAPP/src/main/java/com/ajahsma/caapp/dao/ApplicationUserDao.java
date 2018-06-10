package com.ajahsma.caapp.dao;

import java.util.List;

import com.ajahsma.caapp.model.ApplicationUserModel;

/**
 * @author SHARAN A
 */
public interface ApplicationUserDao extends DefaultDao {

	List<ApplicationUserModel> login(ApplicationUserModel applicationUser);

	ApplicationUserModel findByUserName(String string);
	
	public List<ApplicationUserModel> findUsers(String userRoleName);

	public List<ApplicationUserModel> findApplicationUsers();
}
