package com.ajahsma.caapp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ajahsma.caapp.dao.TasksDao;
import com.ajahsma.caapp.model.ClientNatureOfAssignmentModel;
import com.ajahsma.caapp.model.TasksModel;

/**
 * @author Dev
 *
 */

@Repository
public class TasksDaoImpl extends GenericsDaoImpl implements TasksDao
{

	@Override
	public List<ClientNatureOfAssignmentModel> getTasksByCustomerId(int id) {
		Query query = getSession().createQuery("from ClientNatureOfAssignmentModel cnoam where cnoam.clientModel.clientId=:id and cnoam.natureStatus=:natureStatus");
		query.setParameter("id", id);
		query.setParameter("natureStatus", "CREATED");
		List<ClientNatureOfAssignmentModel>  clientNatureOfAssignmentModels = (List<ClientNatureOfAssignmentModel>) query.list();
		return clientNatureOfAssignmentModels;
	}

	
	public List<TasksModel> getPendingTasks(int id) 
	{
		Query query = getSession().createQuery("from TasksModel tasks where tasks.employeeModel.employeeId=:id");
		query.setParameter("id", id);
		List<TasksModel> list = (List<TasksModel>) query.list();
		return list;
	}


	@Override
	public List<TasksModel> listOfAssignedTasks() {
		Query query = getSession().createQuery("from TasksModel tasks");
		List<TasksModel> listOfTasks = query.list();
		return listOfTasks;
	}
	
}
