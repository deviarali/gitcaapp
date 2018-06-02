package com.ajahsma.caapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajahsma.caapp.constants.ErrorCodes;
import com.ajahsma.caapp.dao.EmployeeDao;
import com.ajahsma.caapp.dto.EmployeeDto;
import com.ajahsma.caapp.exception.BusinessException;
import com.ajahsma.caapp.model.EmployeeModel;
import com.ajahsma.caapp.service.EmployeeService;
import com.ajahsma.caapp.utils.CaAppUtils;

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
	public void employeeRegister(EmployeeDto employeeDto) throws BusinessException{
		EmployeeModel employeeModel = new EmployeeModel();
		EmployeeModel isPresent = employeeDao.findByEmailOrMobile(employeeDto.getEmployeeEmail(), employeeDto.getEmployeeMobile());
		if(CaAppUtils.isNotNull(isPresent))
		{
			throw new BusinessException(ErrorCodes.EORMEXISTS.name(), ErrorCodes.EORMEXISTS.value());
		}
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
		employeeDao.saveDomain(employeeModel);
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
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setEmployeeId(employeeModel.getEmployeeId());
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
			assigneeListDto.add(employeeDto);
		}
		return assigneeListDto;
	}
	
	@Override
	public EmployeeDto getEmployee(Integer id) {
		EmployeeModel employeeModel= employeeDao.getEmployee(id);
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmployeeId(employeeModel.getEmployeeId());
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
		
		return employeeDto;
		
	}


}
