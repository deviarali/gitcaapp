/**
 * 
 */
package com.ajahsma.caapp.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ajahsma.caapp.dao.GenericsDao;

/**
 * @author Dev
 *
 */

@Transactional
public class GenericsDaoImpl implements GenericsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public <E> void save(E entity) {
		getSession().save(entity);
	}
	@Override
	public <E> void update(E entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <E> void delete(E entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <E> List<E> getAll(E entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E> E getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <E> List<E> getModelsList(E entity) {
		return getSession().createCriteria(entity.getClass()).list();
	}
	
	

}
