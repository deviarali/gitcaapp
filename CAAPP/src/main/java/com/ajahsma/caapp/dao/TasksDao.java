package com.ajahsma.caapp.dao;

import java.util.List;

import com.ajahsma.caapp.model.ClientNatureOfAssignmentModel;
import com.ajahsma.caapp.model.TasksModel;

public interface TasksDao extends GenericsDao
{

	List<ClientNatureOfAssignmentModel> getTasksByCustomerId(int id);

	List<TasksModel> getPendingTasks(int id);
	
	List<TasksModel> listOfAssignedTasks();

}
