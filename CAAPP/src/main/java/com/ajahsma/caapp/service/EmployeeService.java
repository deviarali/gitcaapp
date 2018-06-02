package com.ajahsma.caapp.service;

import java.util.List;

import com.ajahsma.caapp.dto.EmployeeDto;
import com.ajahsma.caapp.model.EmployeeModel;

public interface EmployeeService extends DefaultManager {

	void employeeRegister(EmployeeDto employeeDto);

	List<EmployeeModel> getAssigneeList();

	public List<EmployeeDto> findEmployees();
	
	public EmployeeDto getEmployee(Integer id);
	
}
