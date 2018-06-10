package com.ajahsma.caapp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ajahsma.caapp.dao.ClientDao;
import com.ajahsma.caapp.model.ClientModel;
import com.ajahsma.caapp.model.ClientTypeModel;
import com.ajahsma.caapp.model.CompanyStatusModel;
import com.ajahsma.caapp.model.NatureOfAssignmentModel;

@Repository
public class ClientDaoImpl extends DefaultDaoImpl  implements ClientDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession()
	{
		return sessionFactory.openSession();
	}
	
	@Override
	public List<ClientTypeModel> getClientTypes() {
		// TODO Auto-generated method stub
		/*Criteria createCriteria = getSession().createCriteria(ClientTypeModel.class);
		List<ClientTypeModel> list = createCriteria.list();
		for(ClientTypeModel clientTypeModel : list)
		{
			System.out.println("dev");
		}*/
		
		Query createQuery = getSession().createQuery("select ctm from ClientTypeModel ctm");
		List<ClientTypeModel> list = createQuery.list();
		
		for(ClientTypeModel clientTypeModel : list)
		{
			System.out.println("ggggg "+clientTypeModel);
		}
		
		return list;
	}

	@Override
	public List<CompanyStatusModel> getCompanyStatus() {
		return getSession().createCriteria(CompanyStatusModel.class).list();
	}

	@Override
	public List<NatureOfAssignmentModel> getNatureOfAssignments() {
		return getSession().createCriteria(NatureOfAssignmentModel.class).list();
	}

	@Override
	public List<ClientModel> getRecentClients() {
		Query query = getSession().createQuery("select distinct cm from ClientModel cm order by cm.id DESC");
//		query.setMaxResults(3);
		List<ClientModel> list = query.list();
		return list;
	}

	@Override
	public List<ClientModel> getAllClients() {
		/*Criteria criteria = getSession().createCriteria(ClientModel.class);
		List<ClientModel> clientsList = criteria.list();
		return clientsList;*/
		
		Query query = getSession().createQuery("from ClientModel cm");
		return query.list();
		
	}

}
