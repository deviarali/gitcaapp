package com.ajahsma.caapp.dao;

import com.ajahsma.caapp.model.ParameterModel;

/**
 * @author SHARAN A
 */
public interface ParameterDao extends DefaultDao {

	public ParameterModel getParameter(String parameterName);
	
}
