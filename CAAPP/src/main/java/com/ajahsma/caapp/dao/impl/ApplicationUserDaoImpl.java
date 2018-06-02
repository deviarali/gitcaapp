package com.ajahsma.caapp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ajahsma.caapp.dao.ApplicationUserDao;
import com.ajahsma.caapp.model.ApplicationUserModel;


/**
 * @author SHARAN A
 */

@Repository
@SuppressWarnings("unchecked")
public class ApplicationUserDaoImpl extends GenericsDaoImpl implements ApplicationUserDao {

	@Override
	public List<ApplicationUserModel> login(ApplicationUserModel applicationUser) {
		
		Criteria criteria = getSession().createCriteria(applicationUser.getClass());
		criteria.add(Restrictions.eq("userName", applicationUser.getUserName()));
		
		return criteria.list();
		
	}

	@Override
	public ApplicationUserModel findByUserName(String userName) 
	{
		Query query = null;
		
		String hqlQuery = "SELECT applicationuser FROM ApplicationUser applicationuser where applicationuser.userName=:userName";
		
		query = getSession().createQuery(hqlQuery);
		
		query.setParameter("userName", userName);

		ApplicationUserModel user = (ApplicationUserModel) query.uniqueResult();
		
		return user;
		
	}
	
	@Override
	public List<ApplicationUserModel> findUsers(String userRoleName) {
		Query query = null;
		
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT user FROM ApplicationUser user ");
		builder.append("inner join user.userRoles role ");
		builder.append("where role.roleName = :roleName ");
		
		query = getSession().createQuery(builder.toString());
		
		query.setParameter("roleName", userRoleName);
		
		List<ApplicationUserModel>  users = (List) query.list();

		return users;

	}
}
