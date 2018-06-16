package com.ajahsma.caapp.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ajahsma.caapp.dao.ParameterDao;
import com.ajahsma.caapp.model.ParameterModel;


/**
 * @author SHARAN A
 */

@Repository
@SuppressWarnings("unchecked")
public class ParameterDaoImpl extends DefaultDaoImpl implements ParameterDao {


	@Override
	public ParameterModel getParameter(String parameterName) 
	{
		Query query = null;
		
		String hqlQuery = "SELECT parameter FROM Parameter parameter where parameter.parameterName=:parameterName";
		
		query = getSession().createQuery(hqlQuery);
		
		query.setParameter("parameterName", parameterName);

		ParameterModel user = (ParameterModel) query.uniqueResult();
		
		return user;
		
	}

}
