package com.ajahsma.caapp.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajahsma.caapp.dao.TasksDao;
import com.ajahsma.caapp.dto.ClientDto;
import com.ajahsma.caapp.dto.EmployeeDto;
import com.ajahsma.caapp.dto.NatureOfAssignmentDto;
import com.ajahsma.caapp.dto.TasksDto;
import com.ajahsma.caapp.dto.TasksStatusDto;
import com.ajahsma.caapp.model.ApplicationUserModel;
import com.ajahsma.caapp.model.ClientModel;
import com.ajahsma.caapp.model.ClientNatureOfAssignmentModel;
import com.ajahsma.caapp.model.EmployeeModel;
import com.ajahsma.caapp.model.NatureOfAssignmentModel;
import com.ajahsma.caapp.model.TaskModel;
import com.ajahsma.caapp.model.TaskStatus;
import com.ajahsma.caapp.model.TasksStatusModel;
import com.ajahsma.caapp.security.SecurityContextHelper;
import com.ajahsma.caapp.service.ClientService;
import com.ajahsma.caapp.service.EmployeeService;
import com.ajahsma.caapp.service.TasksService;

@Service
public class TasksServiceImpl extends DefaultManagerImpl implements TasksService
{
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	SecurityContextHelper securityContextHelper = new SecurityContextHelper();
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	TasksDao tasksDao;
	
	@Autowired
	public void setDefaultDao(TasksDao defaultDao) {
		this.defaultDao = defaultDao;
	}

	private TasksDao getTasksDao() {
		return (TasksDao) getDefaultDao();
	}
	
	
	@Override
	public List<ClientDto> getAllClients() {
		List<ClientModel> clientsListModel = clientService.getAllClients();
		List<ClientDto> clientsListDto = new ArrayList<>();
		for(ClientModel clientModel : clientsListModel)
		{
			ClientDto clientDto = new ClientDto();
			clientDto.setClientId(clientModel.getId());
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
			employeeDto.setEmployeeId(employeeModel.getId());
			employeeDto.setEmployeeName(employeeModel.getEmployeeName());
			assigneeListDto.add(employeeDto);
		}
		return assigneeListDto;
	}
	
	@Override
	public List<NatureOfAssignmentDto> getTasksByCustomerId(Long id) {
		ClientModel clientModel = (ClientModel) clientService.getDomain(ClientModel.class, id);
		List<NatureOfAssignmentDto> natureOfAssignmentDtos = new ArrayList<>();
		for(NatureOfAssignmentModel natureOfAssignment : clientModel.getNatureOfAssignments())
		{
			NatureOfAssignmentDto natureOfAssignmentDto = new NatureOfAssignmentDto();
			natureOfAssignmentDto.setNatureOfAssignmentId(natureOfAssignment.getId());
			natureOfAssignmentDto.setNatureOfAssignmentName(natureOfAssignment.getNatureOfAssignmentName());
			natureOfAssignmentDtos.add(natureOfAssignmentDto);
		}
		return natureOfAssignmentDtos;
	}

	@Override
	public List<TasksDto> findPendingTasks() {
		Long employeeId = employeeService.getEmployeeFromApplicationUser(SecurityContextHelper.getApplicationUser().getId());
		List<TaskModel> pendingTasksList = tasksDao.findPendingTasks(employeeId);
		List<TasksDto> pendingTasksDto = new ArrayList<>();
		for(TaskModel tasksModel : pendingTasksList)
		{
			TasksDto tasksDto = convertTaskModelToTaskDto(tasksModel);
			/*ClientDto clientDto = new ClientDto();
			NatureOfAssignmentDto natureOfAssignmentDto = new NatureOfAssignmentDto();
			clientDto.setClientName(tasksModel.getClientModel().getClientName());
			natureOfAssignmentDto.setNatureOfAssignmentName(tasksModel.getNatureOfAssignmentModel().getNatureOfAssignmentName());
			tasksDto.setId(tasksModel.getId());
			tasksDto.setClientDto(clientDto);
			tasksDto.setTaskRemarksByEmployee(tasksModel.getTaskRemarksByEmployee());
			tasksDto.setNatureOfAssignmentDto(natureOfAssignmentDto);*/
			pendingTasksDto.add(tasksDto);
		}
		return pendingTasksDto;
	}

	@Override
	public List<TasksDto> findCompletedTasks() {
		Long employeeId = employeeService.getEmployeeFromApplicationUser(SecurityContextHelper.getApplicationUser().getId());
		List<TaskModel> completedTasksList = tasksDao.findCompletedTasks(employeeId);
		List<TasksDto> completedTasksDto = new ArrayList<>();
		for(TaskModel tasksModel : completedTasksList)
		{
			TasksDto tasksDto = convertTaskModelToTaskDto(tasksModel);
			/*ClientDto clientDto = new ClientDto();
			NatureOfAssignmentDto natureOfAssignmentDto = new NatureOfAssignmentDto();
			clientDto.setClientName(tasksModel.getClientModel().getClientName());
			natureOfAssignmentDto.setNatureOfAssignmentName(tasksModel.getNatureOfAssignmentModel().getNatureOfAssignmentName());
			tasksDto.setId(tasksModel.getId());
			tasksDto.setClientDto(clientDto);
			tasksDto.setTaskRemarksByEmployee(tasksModel.getTaskRemarksByEmployee());
			tasksDto.setNatureOfAssignmentDto(natureOfAssignmentDto);*/
			completedTasksDto.add(tasksDto);
		}
		return completedTasksDto;
	}

	@Override
	public void saveTasks(TasksDto tasksDto) 
	{
		/*TaskModel tasksModel = new TaskModel();
		ClientModel clientModel = new ClientModel();
		EmployeeModel employeeModel = new EmployeeModel();
		TasksStatusModel tasksStatusModel = new TasksStatusModel();
		tasksStatusModel.setTasksStatusId(1);
		employeeModel.setEmployeeId(tasksDto.getTaskAssigneeId().getEmployeeId());
		clientModel.setClientId(tasksDto.getClientDto().getClientId());
		
		tasksModel.setClientModel(clientModel);
		tasksModel.setTaskAssigneeId(employeeModel);
		tasksModel.setTaskCreatedDate(new Date());
		tasksModel.setTaskStartDate(tasksDto.getTaskStartDate());
		tasksModel.setTaskStatusId(tasksStatusModel);
		tasksModel.setPriorityStatus(tasksDto.getPriorityStatus());
		tasksModel.setTaskStatus(tasksDto.getTaskStatus());*/
		String[] tasks = tasksDto.getTasks();
		for (String tasksId : tasks) {
			TaskModel tasksModel = convertTaskDtoToTaskModel(tasksDto);
			NatureOfAssignmentModel natureOfAssignmentModel = new NatureOfAssignmentModel();
			natureOfAssignmentModel.setId(Long.parseLong(tasksId));
			tasksModel.setNatureOfAssignmentModel(natureOfAssignmentModel);
			tasksModel.setTaskStatus(TaskStatus.ASSIGNED);
			tasksDao.saveDomain(tasksModel);
		}
	}

	@Override
	public List<TasksDto> findAssignedTasks() {
		Long employeeId = employeeService.getEmployeeFromApplicationUser(SecurityContextHelper.getApplicationUser().getId());
		List<TaskModel> listOftasksModel = tasksDao.findAssignedTasks(employeeId);
		List<TasksDto> listOfTasksDto = new ArrayList<>();
		for(TaskModel tasksModel : listOftasksModel)
		{
			/*TasksDto tasksDto = new TasksDto();
			EmployeeDto employeeDto = new EmployeeDto();
			ClientDto clientDto = new ClientDto();
			NatureOfAssignmentDto natureOfAssignmentDto = new NatureOfAssignmentDto();
			TasksStatusDto tasksStatusDto = new  TasksStatusDto();
			natureOfAssignmentDto.setNatureOfAssignmentName(tasksModel.getNatureOfAssignmentModel().getNatureOfAssignmentName());
			employeeDto.setEmployeeName(tasksModel.getTaskAssigneeId().getEmployeeName());
			clientDto.setClientName(tasksModel.getClientModel().getClientName());
			tasksStatusDto.setTasksStatusName(tasksModel.getTaskStatusId().getTasksStatusName());
			tasksDto.setTaskAssigneeId(employeeDto);
			tasksDto.setClientDto(clientDto);
			tasksDto.setNatureOfAssignmentDto(natureOfAssignmentDto);
			tasksDto.setStartDate(sdf.format(tasksModel.getTaskStartDate()));
			tasksDto.setTaskStatusId(tasksStatusDto);*/
			TasksDto tasksDto = convertTaskModelToTaskDto(tasksModel);
			listOfTasksDto.add(tasksDto);
		}
		return listOfTasksDto;
	}
	
	private TaskModel convertTaskDtoToTaskModel(TasksDto tasksDto) {
		TaskModel tasksModel = new TaskModel();
		ClientModel clientModel = new ClientModel();
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setId(tasksDto.getTaskAssigneeId().getEmployeeId());
		clientModel.setId(tasksDto.getClientDto().getClientId());
		
		tasksModel.setId(tasksDto.getId());
		tasksModel.setClientModel(clientModel);
		tasksModel.setEmployeeModel(employeeModel);
		tasksModel.setTaskCreatedDate(Calendar.getInstance());
		tasksModel.setTaskStartDate(tasksDto.getTaskStartDate());
		tasksModel.setCompletedDate(tasksDto.getCompletedDate());
//		TasksStatusModel tasksStatusModel = new TasksStatusModel();
//		tasksStatusModel.setId(new Long(1));
//		tasksModel.setTasksStatusModel(tasksStatusModel);
		tasksModel.setPriorityStatus(tasksDto.getPriorityStatus());
		tasksModel.setTaskStatus(tasksDto.getTaskStatus());
		tasksModel.setTaskRemarksByAdmin(tasksDto.getTaskRemarksByAdmin());
		tasksModel.setTaskRemarksByEmployee(tasksDto.getTaskRemarksByEmployee());

		if(tasksDto.getTaskStatus() != null) {
			tasksModel.setTaskStatus(tasksDto.getTaskStatus());
		}
		
		return tasksModel;
	}
	
	private TasksDto convertTaskModelToTaskDto(TaskModel tasksModel) {
		TasksDto tasksDto = new TasksDto();
		EmployeeDto employeeDto = new EmployeeDto();
		ClientDto clientDto = new ClientDto();
		NatureOfAssignmentDto natureOfAssignmentDto = new NatureOfAssignmentDto();
		TasksStatusDto tasksStatusDto = new  TasksStatusDto();
		natureOfAssignmentDto.setNatureOfAssignmentName(tasksModel.getNatureOfAssignmentModel().getNatureOfAssignmentName());
		employeeDto.setEmployeeName(tasksModel.getEmployeeModel().getEmployeeName());
		clientDto.setClientName(tasksModel.getClientModel().getClientName());
//		tasksStatusDto.setTasksStatusName(tasksModel.getTasksStatusModel().getTasksStatusName());
		tasksDto.setId(tasksModel.getId());
		tasksDto.setTaskAssigneeId(employeeDto);
		tasksDto.setClientDto(clientDto);
		tasksDto.setNatureOfAssignmentDto(natureOfAssignmentDto);
		tasksDto.setTasksStatusDto(tasksStatusDto);
		tasksDto.setTaskCreatedDate(tasksModel.getTaskCreatedDate());
		tasksDto.setTaskStartDate(tasksModel.getTaskStartDate());
		tasksDto.setCompletedDate(tasksModel.getCompletedDate());
		tasksDto.setPriorityStatus(tasksModel.getPriorityStatus());
		tasksDto.setTaskStatus(tasksModel.getTaskStatus());
		tasksDto.setTaskRemarksByAdmin(tasksModel.getTaskRemarksByAdmin());
		tasksDto.setTaskRemarksByEmployee(tasksModel.getTaskRemarksByEmployee());
		
		return tasksDto;
	}
	
}
