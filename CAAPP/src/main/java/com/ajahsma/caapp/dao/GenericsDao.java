/**
 * 
 */
package com.ajahsma.caapp.dao;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author Dev
 *
 */
public interface GenericsDao 
{
	public <E> void save(E entity);
	
	public <E> void update(E entity);
	
	public <E> void delete(E entity);
	
	public <E> E getById(int id);
	
	public <E> List<E> getAll(E entity);
	
	public <E> List<E> getModelsList(E entity);
}
