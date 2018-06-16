package com.ajahsma.caapp.service;

import java.util.List;

import com.ajahsma.caapp.dto.ClientDto;
import com.ajahsma.caapp.dto.EmployeeDto;
import com.ajahsma.caapp.dto.NatureOfAssignmentDto;
import com.ajahsma.caapp.dto.TasksDto;

public interface TasksService extends DefaultManager {

	List<ClientDto> getAllClients();

	List<EmployeeDto> getAssigneeList();

	List<NatureOfAssignmentDto> getTasksByCustomerId(Long id);

	List<TasksDto> findPendingTasks();
	
	List<TasksDto> findCompletedTasks();
	
	void saveTasks(TasksDto tasksDto);

	List<TasksDto> findAssignedTasks();

	public Integer getTasksCountBy(Long clientId, Long employeeId, Long natureOfAssignmentId);
	
}
