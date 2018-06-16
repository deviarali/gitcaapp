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
public class ApplicationUserDaoImpl extends DefaultDaoImpl implements ApplicationUserDao {

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

		StringBuilder builder = new StringBuilder();
		builder.append("SELECT user FROM ApplicationUser user ");
		builder.append("inner join user.userRoles role ");
		builder.append("where role.roleName = :roleName ");
		
		Query query = getSession().createQuery(builder.toString());
		
		query.setParameter("roleName", userRoleName);
		
		List<ApplicationUserModel>  users = (List) query.list();

		return users;

	}

	@Override
	public List<ApplicationUserModel> findApplicationUsers() {

		Query query = createQuery("select distinct au from ApplicationUser au ");
		
		return query.list();
	}

	@Override
	public Integer getApplicationUserCount(String userName, Long excludeId) {
		Query query = null;
		
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT count(applicationuser) FROM ApplicationUser applicationuser ");
		builder.append(" where applicationuser.userName=:userName ");
		if(excludeId != null) {
			builder.append(" and applicationuser.id != :id ");
		}
//		String hqlQuery = "SELECT counnt(applicationuser) FROM ApplicationUser applicationuser where applicationuser.userName=:userName";
		
		query = getSession().createQuery(builder.toString());
		
		query.setParameter("userName", userName);

		if(excludeId != null) {
			query.setParameter("id", excludeId);
		}
		
		Integer result = ((Long)query.uniqueResult()).intValue();
		
		return result;
		
	}
	
	/*@Override
	public Integer getApplicationUserCount(String userName, Long excludeId) {

		String hqlQuery = "SELECT count(*) FROM ApplicationUser applicationuser where applicationuser.userName=:userName and applicationuser.id != :id";
		
		Query query = getSession().createQuery(hqlQuery);
		
		query.setParameter("userName", userName);
		query.setParameter("id", excludeId);

		Long userCount = (Long) query.uniqueResult();

		return userCount.intValue();
	}*/

	@Override
	public Integer getApplicationUserCount(String userName) {

		Query query = null;
		
		String hqlQuery = "SELECT count(applicationuser.id) FROM ApplicationUser applicationuser where applicationuser.userName=:userName";
		
		query = getSession().createQuery(hqlQuery);
		
		query.setParameter("userName", userName);

		Integer userCount = (Integer) query.uniqueResult();

		return userCount;
	}
}
