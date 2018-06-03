package com.ajahsma.caapp.dao;

import java.util.List;

import com.ajahsma.caapp.model.ClientNatureOfAssignmentModel;
import com.ajahsma.caapp.model.TaskModel;

public interface TasksDao extends DefaultDao
{

	List<ClientNatureOfAssignmentModel> getTasksByCustomerId(int id);

	List<TaskModel> getPendingTasks(int id);
	
	List<TaskModel> getCompletedTasks(Integer id);
	
	List<TaskModel> listOfAssignedTasks();

}
