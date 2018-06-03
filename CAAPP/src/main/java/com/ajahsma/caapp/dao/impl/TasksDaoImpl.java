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
	public List<ClientNatureOfAssignmentModel> getTasksByCustomerId(Integer id) {
		Query query = getSession().createQuery("from ClientNatureOfAssignmentModel cnoam where cnoam.clientModel.clientId=:id and cnoam.natureStatus=:natureStatus");
		query.setParameter("id", id);
		query.setParameter("natureStatus", "CREATED");
		List<ClientNatureOfAssignmentModel>  clientNatureOfAssignmentModels = (List<ClientNatureOfAssignmentModel>) query.list();
		return clientNatureOfAssignmentModels;
	}

	
	public List<TaskModel> findPendingTasks(Integer id) 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("from TaskModel tasks ");
		builder.append("where taskStatus in ('IN_PROGRESS', 'RE_ASSIGNED') ");
		if(SecurityContextHelper.isAdmin()) {
			return getSession().createQuery(builder.toString()).list();
		}
		if(id != null) {
			builder.append(" and tasks.employeeModel.employeeId=:id ");
		}
		
		Query query = getSession().createQuery(builder.toString());
		
		if(id != null) {
			query.setParameter("id", id);
		}
		
		return query.list();	
	}

	@Override
	public List<TaskModel> findCompletedTasks(Integer id) 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("from TaskModel tasks ");
		builder.append("where taskStatus in ('COMPLETED', 'PARTIALLY_COMPLETED') ");
		if(SecurityContextHelper.isAdmin()) {
			return getSession().createQuery(builder.toString()).list();
		}
		if(id != null) {
			builder.append(" and tasks.employeeModel.employeeId=:id ");
		}
		
		Query query = getSession().createQuery(builder.toString());
		
		if(id != null) {
			query.setParameter("id", id);
		}
		
		return query.list();
	}


	@Override
	public List<TaskModel> findAssignedTasks(Integer id) {
		StringBuilder builder = new StringBuilder();
		builder.append("from TaskModel tasks ");
		builder.append("where taskStatus in ('ASSIGNED', 'RE_ASSIGNED') ");
		if(SecurityContextHelper.isAdmin()) {
			return getSession().createQuery(builder.toString()).list();
		}
		if(id != null) {
			builder.append(" and tasks.employeeModel.employeeId=:id ");
		}
		
		Query query = getSession().createQuery(builder.toString());
		
		if(id != null) {
			query.setParameter("id", id);
		}
		
		return query.list();
	}
	
}
