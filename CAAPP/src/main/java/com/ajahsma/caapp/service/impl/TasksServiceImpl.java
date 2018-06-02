package com.ajahsma.caapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajahsma.caapp.dao.TasksDao;
import com.ajahsma.caapp.dto.ClientDto;
import com.ajahsma.caapp.dto.EmployeeDto;
import com.ajahsma.caapp.dto.NatureOfAssignmentDto;
import com.ajahsma.caapp.dto.TasksDto;
import com.ajahsma.caapp.model.ClientModel;
import com.ajahsma.caapp.model.ClientNatureOfAssignmentModel;
import com.ajahsma.caapp.model.EmployeeModel;
import com.ajahsma.caapp.model.TasksModel;
import com.ajahsma.caapp.service.ClientService;
import com.ajahsma.caapp.service.EmployeeService;
import com.ajahsma.caapp.service.TasksService;

@Service
public class TasksServiceImpl implements TasksService
{
	@Autowired
	ClientService clientService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	TasksDao tasksDao;
	
	@Override
	public List<ClientDto> getAllClients() {
		List<ClientModel> clientsListModel = clientService.getAllClients();
		List<ClientDto> clientsListDto = new ArrayList<>();
		for(ClientModel clientModel : clientsListModel)
		{
			ClientDto clientDto = new ClientDto();
			clientDto.setClientId(clientModel.getClientId());
			clientDto.setTradeName(clientModel.getTradeName());
			clientsListDto.add(clientDto);
		}
		return clientsListDto;
	}

	@Override
	public List<EmployeeDto> getAssigneeList() {
		List<EmployeeModel> assigneeListModel = employeeService.getAssigneeList();
		List<EmployeeDto> assigneeListDto = new ArrayList<>();
		for(EmployeeModel employeeModel : assigneeListModel)
		{
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setEmployeeId(employeeModel.getEmployeeId());
			employeeDto.setEmployeeName(employeeModel.getEmployeeName());
			assigneeListDto.add(employeeDto);
		}
		return assigneeListDto;
	}
	
	@Override
	public List<NatureOfAssignmentDto> getTasksByCustomerId(int id) {
		List<ClientNatureOfAssignmentModel> clientNatureOfAssignmentModels = tasksDao.getTasksByCustomerId(id);
		List<NatureOfAssignmentDto> natureOfAssignmentDtos = new ArrayList<>();
		for(ClientNatureOfAssignmentModel assignmentModel : clientNatureOfAssignmentModels)
		{
			NatureOfAssignmentDto natureOfAssignmentDto = new NatureOfAssignmentDto();
			natureOfAssignmentDto.setNatureOfAssignmentId(assignmentModel.getNatureOfAssignmentModel().getNatureOfAssignmentId());
			natureOfAssignmentDto.setNatureOfAssignmentName(assignmentModel.getNatureOfAssignmentModel().getNatureOfAssignmentName());
			natureOfAssignmentDtos.add(natureOfAssignmentDto);
		}
		return natureOfAssignmentDtos;
	}

	@Override
	public List<TasksDto> getPendingTasks() {
		List<TasksModel> pendingTasksList = tasksDao.getPendingTasks();
		List<TasksDto> pendingTasks = new ArrayList<>();
		return null;
	}
	
}
