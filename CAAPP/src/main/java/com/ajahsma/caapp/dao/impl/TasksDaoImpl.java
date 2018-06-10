package com.ajahsma.caapp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ajahsma.caapp.dao.TasksDao;
import com.ajahsma.caapp.model.ClientNatureOfAssignmentModel;
import com.ajahsma.caapp.model.TaskModel;
import com.ajahsma.caapp.security.SecurityContextHelper;

/**
 * @author Dev
 *
 */

@Repository
public class TasksDaoImpl extends DefaultDaoImpl implements TasksDao
{

	@Override
	public List<ClientNatureOfAssignmentModel> getTasksByCustomerId(Long id) {
		Query query = getSession().createQuery("from ClientNatureOfAssignmentModel cnoam where cnoam.clientModel.id = :id and cnoam.natureStatus=:natureStatus");
		query.setParameter("id", id);
		query.setParameter("natureStatus", "CREATED");
		List<ClientNatureOfAssignmentModel>  clientNatureOfAssignmentModels = (List<ClientNatureOfAssignmentModel>) query.list();
		return clientNatureOfAssignmentModels;
	}

	
	public List<TaskModel> findPendingTasks(Long id) 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("select distinct task from TaskModel task ");
		builder.append(" inner join task.employeeModel emp ");
		builder.append("where task.taskStatus in ('IN_PROGRESS', 'RE_ASSIGNED', 'PARTIALLY_COMPLETED') ");
		if(SecurityContextHelper.isAdmin()) {
			return getSession().createQuery(builder.toString()).list();
		}
		if(id != null) {
			builder.append(" and emp.id = :id ");
		}
		
		Query query = getSession().createQuery(builder.toString());
		
		if(id != null) {
			query.setParameter("id", id);
		}
		
		return query.list();	
	}

	@Override
	public List<TaskModel> findCompletedTasks(Long id) 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("select distinct task from TaskModel task ");
		builder.append(" inner join task.employeeModel emp ");
		builder.append("where task.taskStatus in ('COMPLETED', 'PARTIALLY_COMPLETED') ");
		if(SecurityContextHelper.isAdmin()) {
			return getSession().createQuery(builder.toString()).list();
		}
		if(id != null) {
			builder.append(" and emp.id = :id ");
		}
		
		Query query = getSession().createQuery(builder.toString());
		
		if(id != null) {
			query.setParameter("id", id);
		}
		
		return query.list();
	}


	@Override
	public List<TaskModel> findAssignedTasks(Long id) {
		StringBuilder builder = new StringBuilder();
		builder.append("select distinct task from TaskModel task ");
		builder.append(" inner join task.employeeModel emp ");
		builder.append(" where task.taskStatus in ('ASSIGNED', 'RE_ASSIGNED') ");
		if(SecurityContextHelper.isAdmin()) {
			return getSession().createQuery(builder.toString()).list();
		}
		if(id != null) {
			builder.append(" and emp.id = :id ");
		}
		
		Query query = getSession().createQuery(builder.toString());
		
		if(id != null) {
			query.setParameter("id", id);
		}
		
		return query.list();
	}
	
}
