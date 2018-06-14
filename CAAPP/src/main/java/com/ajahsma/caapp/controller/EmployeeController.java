package com.ajahsma.caapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ajahsma.caapp.dto.ApplicationUserDto;
import com.ajahsma.caapp.dto.EmployeeDto;
import com.ajahsma.caapp.exception.BusinessException;
import com.ajahsma.caapp.model.EmployeeModel;
import com.ajahsma.caapp.service.ApplicationUserService;
import com.ajahsma.caapp.service.EmployeeService;
import com.ajahsma.caapp.validator.EmployeeValidator;

@Controller
@RequestMapping(value = "/caapp")
public class EmployeeController extends BaseController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeValidator employeeValidator; 
	
	@Autowired
	ApplicationUserService applicationUserService; 
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	private String navigateEmployee(Model model) {

		List<EmployeeDto> employees = employeeService.findEmployees();
		
		model.addAttribute("employees", employees);
		model.addAttribute("employee", new EmployeeDto());

		return "employee";
	}
	
	@RequestMapping(value = "/employee/createEmployee", method = RequestMethod.GET)
	private String createEmployee(Model model)
	{
		model.addAttribute("employee", new EmployeeDto());
		return "createEmployee";
	}
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	private String getEmployee(Model model, @PathVariable("id") Long id) {
		
		EmployeeDto employeeDto = employeeService.getEmployee(id);
		
		model.addAttribute("employee", employeeDto);
		return "createEmployee";
	}
	
	@RequestMapping(value = "/employee/applicaionUser/{id}", method = RequestMethod.GET)
	private String getEmployeeFromApplicaionUser(Model model, @PathVariable("id") Long id) {
		Long empId = employeeService.getEmployeeFromApplicationUser(id);
		EmployeeDto employeeDto = employeeService.getEmployee(empId);
		
		model.addAttribute("employee", employeeDto);
		return "createEmployee";
	}
	
	@RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.GET)
	private String deleteEmployee(Model model, @PathVariable("id") Long id) {
		
		EmployeeModel employee = (EmployeeModel) employeeService.getDomain(EmployeeModel.class, id);
		
		employeeService.deleteDomain(employee);
		
		List<EmployeeDto> employees = employeeService.findEmployees();
		
		model.addAttribute("employees", employees);
		model.addAttribute("employee", new EmployeeDto());

		return "employee";
	}
	
	@RequestMapping(value = "/employee/employeeRegister", method = RequestMethod.POST)
	private ModelAndView employeeRegister(@Valid @ModelAttribute("employee") EmployeeDto employeeDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes)
	{
		try
		{
			employeeValidator.validate(employeeDto, bindingResult);
			if(bindingResult.hasErrors()) {
				model.addAttribute("alert_msg", "Oops! something went wrong...");
				return new ModelAndView("createEmployee", "employee", employeeDto);
			}
			employeeService.employeeRegister(employeeDto);

		}
		catch(BusinessException businessException)
		{
			model.addAttribute("alert_msg", "Oops! " + businessException.getErrorCode() + " : " + businessException.getErrorMsg());
			return new ModelAndView("createEmployee", "employee", employeeDto);
		}
		redirectAttributes.addFlashAttribute("msg", "Employee saved successfully");
		
		List<EmployeeDto> employees = employeeService.findEmployees();
		
		model.addAttribute("employees", employees);
		model.addAttribute("alert_msg", "Employee saved successfully");

		return new ModelAndView("employee", "employee", employeeDto);
	}
	
	@ModelAttribute("userList")
	private List<ApplicationUserDto> findApplicationUserDtoList() {
		
		return applicationUserService.findApplicationUserDtoList();
	}

}
