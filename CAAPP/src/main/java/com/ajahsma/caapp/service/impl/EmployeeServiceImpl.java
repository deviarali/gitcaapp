package com.ajahsma.caapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajahsma.caapp.constants.ErrorCodes;
import com.ajahsma.caapp.dao.EmployeeDao;
import com.ajahsma.caapp.dto.ApplicationUserDto;
import com.ajahsma.caapp.dto.EmployeeDto;
import com.ajahsma.caapp.exception.BusinessException;
import com.ajahsma.caapp.model.ApplicationUserModel;
import com.ajahsma.caapp.model.EmployeeModel;
import com.ajahsma.caapp.service.EmployeeService;

@Service
public class EmployeeServiceImpl extends DefaultManagerImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	public void setDefaultDao(EmployeeDao defaultDao) {
		this.defaultDao = defaultDao;
	}

	private EmployeeDao getEmployeeDao() {
		return (EmployeeDao) getDefaultDao();
	}
	
	@Override
	public void employeeRegister(EmployeeDto employeeDto) {

		EmployeeModel employeeModel = convertEmployeeDtoToEmployeeModel(employeeDto);

		Integer totalEmployeesExists = employeeDao.findEmployeeCountByEmailOrMobile(employeeDto.getEmployeeEmail(), employeeDto.getEmployeeMobile());
		if (employeeModel.getId() == null) {

//			EmployeeModel isPresent = employeeDao.findByEmailOrMobile(employeeDto.getEmployeeEmail(), employeeDto.getEmployeeMobile());
			if (totalEmployeesExists > 0) {
				throw new BusinessException(ErrorCodes.EORMEXISTS.name(), ErrorCodes.EORMEXISTS.value());
			}

			this.saveDomain(employeeModel);
		} else {
			if (totalEmployeesExists > 1) {
				throw new BusinessException(ErrorCodes.EORMEXISTS.name(), ErrorCodes.EORMEXISTS.value());
			}
			this.updateDomain(employeeModel);
		}
	}

	@Override
	public List<EmployeeModel> getAssigneeList() {
		List<EmployeeModel> assigneeList = employeeDao.getAssigneeList();
		return assigneeList;
	}
	
	@Override
	public List<EmployeeDto> findEmployees() {
		List<EmployeeModel> assigneeListModel = employeeDao.findEmployees();
		List<EmployeeDto> assigneeListDto = new ArrayList<>();
		for(EmployeeModel employeeModel : assigneeListModel)
		{
			EmployeeDto employeeDto = convertEmployeeModelToEmployeeDto(employeeModel);

			assigneeListDto.add(employeeDto);
			
		}
		return assigneeListDto;
	}

	private EmployeeModel convertEmployeeDtoToEmployeeModel(EmployeeDto employeeDto) {
		
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setId(employeeDto.getEmployeeId());
		employeeModel.setEmployeeName(employeeDto.getEmployeeName());
		employeeModel.setEmployeeAddress(employeeDto.getEmployeeAddress());
		employeeModel.setEmployeeMobile(employeeDto.getEmployeeMobile());
		employeeModel.setEmployeeEmail(employeeDto.getEmployeeEmail());
		employeeModel.setEmployeeAadhar(employeeDto.getEmployeeAadhar());
		employeeModel.setEmployeePan(employeeDto.getEmployeePan());
		employeeModel.setEmployeeParentAddress(employeeDto.getEmployeeParentAddress());
		employeeModel.setEmployeeJoingDate(new Date());
		employeeModel.setEmployeeJoingDate(employeeDto.getEmployeeJoingDate());
		employeeModel.setEmployeeStatus("ACTIVE");
		
		if(employeeDto.getApplicationUser() != null && employeeDto.getApplicationUser().getId() != null) {
			ApplicationUserModel applicationUserModel = new ApplicationUserModel();
			applicationUserModel.setId(employeeDto.getApplicationUser().getId());
			employeeModel.setApplicationUser(applicationUserModel);
		}

		return employeeModel;
	}
	
	private EmployeeDto convertEmployeeModelToEmployeeDto(EmployeeModel employeeModel) {
		
		
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmployeeId(employeeModel.getId());
		employeeDto.setEmployeeName(employeeModel.getEmployeeName());
		employeeDto.setEmployeeMobile(employeeModel.getEmployeeMobile());
		employeeDto.setEmployeeEmail(employeeModel.getEmployeeEmail());
		employeeDto.setEmployeeAddress(employeeModel.getEmployeeAddress());
		employeeDto.setEmployeePan(employeeModel.getEmployeePan());
		employeeDto.setEmployeeAadhar(employeeModel.getEmployeeAadhar());
		employeeDto.setEmployeeParentAddress(employeeModel.getEmployeeParentAddress());
		employeeDto.setEmployeeStatus(employeeModel.getEmployeeStatus());
		employeeDto.setEmployeeCreatedDate(employeeModel.getEmployeeCreatedDate());
		employeeDto.setEmployeeJoingDate(employeeModel.getEmployeeJoingDate());
		
		if(employeeModel.getApplicationUser() != null && employeeModel.getApplicationUser().getId() != null) {
			ApplicationUserDto applicationUserDto = new ApplicationUserDto();
			applicationUserDto.setId(employeeModel.getApplicationUser().getId());
			applicationUserDto.setUserName(employeeModel.getApplicationUser().getUserName());
			employeeDto.setApplicationUser(applicationUserDto);
		}

		return employeeDto;
	}

	@Override
	public EmployeeDto getEmployee(Long id) {
		EmployeeModel employeeModel= employeeDao.getEmployee(id);
		EmployeeDto employeeDto = convertEmployeeModelToEmployeeDto(employeeModel);
		
		
		return employeeDto;
		
	}

	@Override
	public Long getEmployeeFromApplicationUser(Long applicationUserId) {
		return getEmployeeDao().getEmployeeFromApplicationUser(applicationUserId);
	}
}
