package com.ajahsma.caapp.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.TransientObjectException;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.ajahsma.caapp.dao.DefaultDao;
import com.ajahsma.caapp.model.Domain;

/**
 * @author SHARAN A
 */

@Transactional
public class DefaultDaoImpl extends AbstractDefaultDaoImpl implements DefaultDao {

	protected Query createQuery(String queryString) {
		return getSession().createQuery(queryString);
	}

	@Override
	public Domain get(Class<? extends Domain> domainClass, Serializable id) {
		Criteria criteria = createCriteria(domainClass);
		criteria.add(Restrictions.eq("id", id));
		return (Domain) criteria.list();
	}

	@Override
	public Domain get(Class<? extends Domain> domainClass, Serializable id, String nestedPathToInitialize) {
		String[] nestedPathsToInitialize = convertStringArray(nestedPathToInitialize);
		return get(domainClass, id, nestedPathsToInitialize);
	}

	@Override
	public Domain get(Class<? extends Domain> domainClass, Serializable id, String[] nestedPathsToInitialize) {

		return initializeNestedPathsOfDomain(get(domainClass, id), nestedPathsToInitialize);
		
	}

	protected Criteria createCriteria(Class<?> persistentClass) {
		Criteria criteria = getSession().createCriteria(persistentClass);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria;
	}

	@Override
	public Serializable saveDomain(Domain domain) {
		return getHibernateTemplate().save(domain);
	}

	@Override
	public Domain loadDomain(Class<? extends Domain> domainClass, Serializable id) {

		return (Domain) getHibernateTemplate().load(domainClass, id);
	}

	@Override
	public Domain loadDomain(Class<? extends Domain> domainClass, Serializable id, String nestedPathToInitialize) {
		String[] nestedPathsToInitialize = convertStringArray(nestedPathToInitialize);
		return loadDomain(domainClass, id, nestedPathsToInitialize);
	}

	@Override
	public Domain loadDomain(Class<? extends Domain> domainClass, Serializable id, String[] nestedPathsToInitialize) {
		return initializeNestedPathsOfDomain(loadDomain(domainClass, id), nestedPathsToInitialize);
	}

	@Override
	public Domain getDomain(Class<? extends Domain> domainClass, Serializable id) {
		return (Domain) getHibernateTemplate().get(domainClass, id);
	}

	@Override
	public Domain getDomain(Class<? extends Domain> domainClass, Serializable id, String nestedPathToInitialize) {
		String[] nestedPathsToInitialize = convertStringArray(nestedPathToInitialize);
		
		return getDomain(domainClass, id, nestedPathsToInitialize);
	}

	@Override
	public Domain getDomain(Class<? extends Domain> domainClass, Serializable id, String[] nestedPathsToInitialize) {
		return initializeNestedPathsOfDomain(getDomain(domainClass, id), nestedPathsToInitialize);
	}

	@Override
	public List<Domain> getAllDomain(Class<? extends Domain> domainClass) {
		Criteria criteria = createCriteria(domainClass);
		List list = criteria.list();
		//return (List<Domain>) criteria.list();
		return list;
	}

	@Override
	public List<Domain> getAllDomain(Class<? extends Domain> domainClass, String nestedPathToInitialize) {
		String[] nestedPathsToInitialize = convertStringArray(nestedPathToInitialize);
		return getAllDomain(domainClass, nestedPathsToInitialize);
	}

	@Override
	public List<Domain> getAllDomain(Class<? extends Domain> domainClass, String[] nestedPathsToInitialize) {
		return initializeNestedPathsOfListResults(getAllDomain(domainClass), nestedPathsToInitialize);
	}

	@Override
	public void deleteDomain(Domain domain) {
		getHibernateTemplate().delete(domain);
	}

	@Override
	public void updateDomain(Domain domain) {
		getHibernateTemplate().update(domain);

	}

	public Session getSession() {
		try {
			return getHibernateTemplate().getSessionFactory().getCurrentSession();
		} catch (Exception e) {
			return getHibernateTemplate().getSessionFactory().openSession();
		}
	}

	private String[] convertStringArray(String value) {
		String[] nestedPathsToInitialize = null;
		if (value != null) {
			nestedPathsToInitialize = new String[1];
			nestedPathsToInitialize[0] = value;
		}
		return nestedPathsToInitialize;
	}
	
    @Override
	public void evict(Domain domain) {
		//Assert.isTrue(supports(domain));
    	getHibernateTemplate().evict(domain);
    }
    
    @Override
    public void evict(Collection<? extends Domain>domains)
    {
    	for (Domain domain : domains) {
			evict(domain);
		}
    }
    
    /* (non-Javadoc)
     * @see com.fb.gfw.dal.DefaultDao#flush()
     */
    @Override
    public void flush() {
    	getHibernateTemplate().flush();
    }
    
    @Override
	public Domain initializeNestedPath(Domain domain, String nestedPathToInitialize) {
        Assert.notNull(domain);
        Assert.notNull(nestedPathToInitialize);

        try {
            getHibernateTemplate().lock(domain, LockMode.NONE);
        } catch (DataAccessException dae) {
            if ( !(dae.getCause() instanceof TransientObjectException)) {
                throw dae;
            }
        }
        
        initializeNestedPathsOfDomain(domain, nestedPathToInitialize);
        
        return domain;
    }

    @Override
	public Domain initializeNestedPaths(Domain domain, String[] nestedPathsToInitialize) {
        Assert.notNull(domain);

        try {
            getHibernateTemplate().lock(domain, LockMode.NONE);
        } catch (DataAccessException dae) {
            if ( !(dae.getCause() instanceof TransientObjectException)) {
                throw dae;
            }
        }
        
        initializeNestedPathsOfDomain(domain, nestedPathsToInitialize);
        
        
        return domain;
    }


}
