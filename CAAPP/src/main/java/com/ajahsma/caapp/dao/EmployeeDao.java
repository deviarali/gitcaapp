package com.ajahsma.caapp.dao;

import java.util.List;

import com.ajahsma.caapp.model.EmployeeModel;

public interface EmployeeDao extends DefaultDao {

	EmployeeModel findByEmailOrMobile(String employeeEmail, String employeeMobile);

	List<EmployeeModel> getAssigneeList();

	public List<EmployeeModel> findEmployees();
	
	public EmployeeModel getEmployee(Long id);
	
}
