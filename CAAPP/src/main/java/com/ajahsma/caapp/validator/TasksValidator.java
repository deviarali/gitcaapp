/**
 * 
 */
package com.ajahsma.caapp.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ajahsma.caapp.dto.TasksDto;
import com.ajahsma.caapp.service.TasksService;

/**
 * @author Dev
 *
 */

@Component
public class TasksValidator implements Validator {

	@Autowired
	TasksService taskService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return TasksDto.class.equals(clazz);
	}

	@Override
	public void validate(Object taskObject, Errors errors) 
	{
		TasksDto tasksDto = (TasksDto) taskObject;
		
		if(tasksDto.getId() == null 
				&& tasksDto.getClientDto() != null
				&& tasksDto.getClientDto().getClientId() != null
				&& tasksDto.getTaskAssigneeId() != null 
				&& tasksDto.getTaskAssigneeId().getEmployeeId() != null
				&& tasksDto.getTasks() != null 
				&& tasksDto.getTasks().length > 0) 
		{
			String[] tasks = tasksDto.getTasks();
			for (String tasksId : tasks) {
				Integer taskExistCount = taskService.getTasksCountBy(tasksDto.getClientDto().getClientId(), tasksDto.getTaskAssigneeId().getEmployeeId(), Long.valueOf(tasksId));
				if(taskExistCount > 0) {
//					errors.rejectValue("clientDto.clientId", "task.client.alreadyExists", new Object[] { tasksDto.getClientDto().getClientId(), tasksDto.getTaskAssigneeId().getEmployeeId()}, "This task already Assigned");
					errors.rejectValue("clientDto.clientId", "task.client.alreadyExists", "This task already Assigned");
					break;
				}
			}
		}
		if(tasksDto.getClientDto().getClientId() == null || tasksDto.getClientDto().getClientId() == -1)
		{
			errors.rejectValue("clientDto.clientId", "task.client.required");
		}
		if(tasksDto.getTaskAssigneeId() == null || tasksDto.getTaskAssigneeId().getEmployeeId() == null || tasksDto.getTaskAssigneeId().getEmployeeId() == -1)
		{
			errors.rejectValue("taskAssigneeId.employeeId", "task.assignee.required");
		}
		if(tasksDto.getPriorityStatus() == null || tasksDto.getPriorityStatus().getName() == "-1")
		{
			errors.rejectValue("priorityStatus", "task.priority.required");
		}
		if(tasksDto.getTaskStartDate() == null)
		{
			errors.rejectValue("taskStartDate", "task.dateofstart.required");
		}
		if(tasksDto.getTasks() == null || tasksDto.getTasks().length <= 0)
		{
			errors.rejectValue("tasks", "task.natureOfAssignment.min.one.required");
		}
	}

}
