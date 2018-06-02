package com.ajahsma.caapp.dao;

import java.util.List;

import com.ajahsma.caapp.model.ApplicationUserModel;

/**
 * @author SHARAN A
 */
public interface ApplicationUserDao extends GenericsDao {

	List<ApplicationUserModel> login(ApplicationUserModel applicationUser);

	ApplicationUserModel findByUserName(String string);
	
	public List<ApplicationUserModel> findUsers(String userRoleName);
}
