package com.ajahsma.caapp.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.ajahsma.caapp.model.Domain;

/**
 * @author SHARAN A
 */

public interface DefaultManager {

	Domain createNewTransientDomain(String domainClassName) throws Exception;
	
	Domain createNewTransientDomain(String domainClassName, Boolean isSearchMode) throws Exception;
	
	Serializable saveDomain(Domain domain);
	
	void saveAll(List<Domain> domains);
	
	public Domain initializeNestedPath(Domain domain, String nestedPathToInitialize);
	
	public Domain initializeNestedPaths(Domain domain, String[] nestedPathsToInitialize);
	
	Domain loadDomain(Class<? extends Domain> domainClass, Serializable id);
	
	Domain loadDomain(Class<? extends Domain> domainClass, Serializable id, String nestedPathToInitialize);
	
	Domain loadDomain(Class<? extends Domain> domainClass, Serializable id, String[] nestedPathsToInitialize);
	
	Domain getDomain(Class<? extends Domain> domainClass, Serializable id);
	
	Domain getDomain(Class<? extends Domain> domainClass, Serializable id, String nestedPathToInitialize);
	
	Domain getDomain(Class<? extends Domain> domainClass, Serializable id, String[] nestedPathsToInitialize);
	
	public List<Domain> getAllDomain(Class<? extends Domain> domainClass);
	
	public List<Domain> getAllDomain(Class<? extends Domain> domainClass, String nestedPathToInitialize);
	
	public List<Domain> getAllDomain(Class<? extends Domain> domainClass, String[] nestedPathsToInitialize);
	
	void deleteDomain(Domain domain);
	
	void updateDomain(Domain domain);
	
	public Domain get(Class<? extends Domain> domainClass, Serializable id);

	public Domain get(Class<? extends Domain> domainClass, Serializable id, String nestedPathToInitialize);

	public Domain get(Class<? extends Domain> domainClass, Serializable id, String[] nestedPathsToInitialize);
	
    void evict(Domain domain);
    void evict(Collection<? extends Domain>domain);
    

}
