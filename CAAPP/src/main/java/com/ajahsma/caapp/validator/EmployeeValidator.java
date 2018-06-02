package com.ajahsma.caapp.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ajahsma.caapp.dto.EmployeeDto;

/**
 * @author Dev
 *
 */
@Component
public class EmployeeValidator implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return EmployeeDto.class.equals(clazz);
	}

	@Override
	public void validate(Object employeeObject, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeName", "employee.firstname.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeAddress","employee.address.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeePan", "employee.pan.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeMobile", "employee.mobile.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeEmail", "employee.email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeJoingDate", "employee.employeeJoingDate.required");
		
		/*EmployeeDto employeeDto = (EmployeeDto) employeeObject;
		if(!StringUtils.hasText(employeeDto.getEmployeeName())) {
			errors.rejectValue("employeeName", "employee.firstname.required");
		}
		if(!StringUtils.hasText(employeeDto.getEmployeeAddress())) {
			errors.rejectValue("employeeAddress", "employee.address.required");
		}
		if(!StringUtils.hasText(employeeDto.getEmployeePan())) {
			errors.rejectValue("employeePan", "employee.pan.required");
		}
		if(!StringUtils.hasText(employeeDto.getEmployeeMobile())) {
			errors.rejectValue("employeeMobile", "employee.mobile.required");
		}
		if(!StringUtils.hasText(employeeDto.getEmployeeEmail())) {
			errors.rejectValue("employeeEmail", "employee.email.required");
		}
		if(employeeDto.getEmployeeJoingDate() == null) {
			errors.rejectValue("employeeJoingDate", "employee.employeeJoingDate.required");
		}*/
		
	}

}
