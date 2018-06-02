package com.ajahsma.caapp.service;

import java.util.List;

import com.ajahsma.caapp.dto.ClientDto;
import com.ajahsma.caapp.dto.EmployeeDto;
import com.ajahsma.caapp.dto.NatureOfAssignmentDto;
import com.ajahsma.caapp.dto.TasksDto;

public interface TasksService {

	List<ClientDto> getAllClients();

	List<EmployeeDto> getAssigneeList();

	List<NatureOfAssignmentDto> getTasksByCustomerId(int id);

	List<TasksDto> getPendingTasks();

}
