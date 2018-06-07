/**
 * 
 */
package com.ajahsma.caapp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ajahsma.caapp.dto.TasksDto;

/**
 * @author Dev
 *
 */

@Component
public class TasksValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TasksDto.class.equals(clazz);
	}

	@Override
	public void validate(Object taskObject, Errors errors) 
	{
		TasksDto tasksDto = (TasksDto) taskObject;
		if(tasksDto.getClientDto().getClientId() == -1)
		{
			errors.rejectValue("clientDto.clientId", "task.client.required");
		}
		if(tasksDto.getTaskAssigneeId().getEmployeeId() == -1)
		{
			errors.rejectValue("taskAssigneeId.employeeId", "task.assignee.required");
		}
		if(tasksDto.getPriorityStatus() == null || tasksDto.getPriorityStatus().getName() == "-1")
		{
			errors.rejectValue("priorityStatus", "task.priority.required");
		}
		if(tasksDto.getTaskStatus() == null || tasksDto.getTaskStatus().getName() == "-1")
		{
			errors.rejectValue("taskStatus", "task.status.required");
		}
		if(tasksDto.getTaskStartDate() == null)
		{
			errors.rejectValue("taskStartDate", "task.dateofstart.required");
		}
		if(tasksDto.getTasks() == null || tasksDto.getTasks().length == -1)
		{
			errors.rejectValue("tasks", "task.natureOfAssignment.min.one.required");
		}
	}

}
