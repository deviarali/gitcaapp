package com.ajahsma.caapp.dao;

import java.util.List;

import com.ajahsma.caapp.model.ClientNatureOfAssignmentModel;
import com.ajahsma.caapp.model.TaskModel;

public interface TasksDao extends DefaultDao
{

	List<ClientNatureOfAssignmentModel> getTasksByCustomerId(Long id);

	List<TaskModel> findPendingTasks(Long id);
	
	List<TaskModel> findCompletedTasks(Long id);
	
	List<TaskModel> findAssignedTasks(Long id);

}
