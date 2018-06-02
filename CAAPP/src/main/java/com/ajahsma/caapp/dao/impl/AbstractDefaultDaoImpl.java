package com.ajahsma.caapp.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import com.ajahsma.caapp.dao.HibernateInitializer;
import com.ajahsma.caapp.model.Domain;

public class AbstractDefaultDaoImpl extends HibernateDaoSupport
{
    @Autowired
    public void defaultSessionFactory(SessionFactory sessionFactory)
    {
        setSessionFactory(sessionFactory);
        if(getHibernateTemplate() != null) {
            getHibernateTemplate().setCheckWriteOperations(false);
        }
    }
    
    protected Domain initializeNestedPathsOfDomain(Domain domain, String[] nestedPathsToInitialize) {
        Assert.notNull(domain);
        
        getHibernateInitializer().initialize(domain, nestedPathsToInitialize);
        
        return domain;
    }        

    protected Domain initializeNestedPathsOfDomain(Domain domain, String nestedPathsToInitialize) {
        Assert.notNull(domain);
        
        getHibernateInitializer().initialize(domain, nestedPathsToInitialize);
        
        return domain;
    }        

    protected List initializeNestedPathsOfListResults(List results, String[] nestedPathsToInitialize) {
        Assert.notNull(results);
        
        getHibernateInitializer().initialize(results, nestedPathsToInitialize);
        
        return results;
    }

    private HibernateInitializer getHibernateInitializer() {
        return new BeanWrapperHibernateInitializer(getHibernateTemplate());
    }


}