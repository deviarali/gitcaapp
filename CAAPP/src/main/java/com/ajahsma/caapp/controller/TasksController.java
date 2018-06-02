package com.ajahsma.caapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ajahsma.caapp.dto.ClientDto;
import com.ajahsma.caapp.dto.EmployeeDto;
import com.ajahsma.caapp.dto.NatureOfAssignmentDto;
import com.ajahsma.caapp.dto.TasksDto;
import com.ajahsma.caapp.model.PriorityStatus;
import com.ajahsma.caapp.model.TaskStatus;
import com.ajahsma.caapp.service.TasksService;

@Controller
@RequestMapping(value = "/caapp")
public class TasksController 
{
	
	@Autowired
	TasksService tasksService;
	
	@RequestMapping(value = "/tasks/createTasks", method = RequestMethod.GET )
	public ModelAndView createTasks(Model model)
	{
		List<ClientDto> clientsList = tasksService.getAllClients();
		List<EmployeeDto> assigneeList = tasksService.getAssigneeList();
		model.addAttribute("clientsList", clientsList);
		model.addAttribute("assigneeList", assigneeList);
//		model.addAttribute("priorityStatusList", PriorityStatus.values());
//		model.addAttribute("taskStatusList", TaskStatus.values());
		return new ModelAndView("creattask", "tasks", new TasksDto());
	}
	
	@ModelAttribute("priorityStatusList")
    public PriorityStatus[] populatePriorityStatus()
    {
        return PriorityStatus.values();
    }
	
	@ModelAttribute("taskStatusList")
    public TaskStatus[] populateTaskStatus()
    {
        return TaskStatus.values();
    }
	
	@RequestMapping(value = "/tasks/saveTasks", method = RequestMethod.POST )
	public ModelAndView saveTasks(TasksDto tasksDto, BindingResult result, Errors errors, RedirectAttributes redirectAttributes)
	{
		tasksService.saveTasks(tasksDto);
		redirectAttributes.addAttribute("msg", "Tasks created successfully");
		return new ModelAndView("redirect:/caapp/tasks/createTasks");
		
		/*List<ClientDto> clientsList = tasksService.getAllClients();
		List<EmployeeDto> assigneeList = tasksService.getAssigneeList();
		List<NatureOfAssignmentDto> listOfTasks = tasksService.getTasksByCustomerId(tasksDto.getClientDto().getClientId());
		Map<String, Object> model = new HashMap<>();
		model.put("clientsList", clientsList);
		model.put("assigneeList", assigneeList);
		model.put("taskList", listOfTasks);
		model.put("tasks", tasksDto);
		return new ModelAndView("creattask", model);*/
	}
	
	@RequestMapping(value = "/tasks/getTasksByCustomerId/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<NatureOfAssignmentDto> getTasksByCustomerId(@PathVariable("id") int id)
	{
		List<NatureOfAssignmentDto> listOfTasks = tasksService.getTasksByCustomerId(id);
		return listOfTasks;
	}
	
	@RequestMapping(value = "/tasks/assignedTasks", method = RequestMethod.GET)
	public String listOfAssignedTasks(Model model)
	{
		List<TasksDto> listOfAssignedTasks = tasksService.listOfAssignedTasks();
		model.addAttribute("listOfAssignedTasks", listOfAssignedTasks);
		return "assignedtasks";
	}
	
	@RequestMapping(value = "/tasks/pendingTasks", method = RequestMethod.GET)
	public String getPendingTasks(Model model)
	{
		List<TasksDto> pendingTasksList = tasksService.getPendingTasks();
		model.addAttribute("pendingTasksList", pendingTasksList);
		return "pendingtasks";
	}
	
	@RequestMapping(value = "/tasks/updateEmployeeRemarks/{id}/{tasksRemarksByEmployee}", method = RequestMethod.GET)
	public String updateEmployeeRemarks(@PathVariable("id") int id, @PathVariable("tasksRemarksByEmployee") String tasksRemarksByEmployee)
	{
		
		return "redirect:/caapp/tasks/pendingTasks";
	}
}
