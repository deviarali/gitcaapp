package com.ajahsma.caapp.dao;

import java.util.List;

import com.ajahsma.caapp.model.ClientNatureOfAssignmentModel;
import com.ajahsma.caapp.model.TaskModel;

public interface TasksDao extends DefaultDao
{

	List<ClientNatureOfAssignmentModel> getTasksByCustomerId(Integer id);

	List<TaskModel> findPendingTasks(Integer id);
	
	List<TaskModel> findCompletedTasks(Integer id);
	
	List<TaskModel> findAssignedTasks(Integer id);

}
