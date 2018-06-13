package com.ajahsma.caapp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ajahsma.caapp.dto.NatureOfAssignmentDto;

@Component
public class NatureOfAssignmentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return NatureOfAssignmentDto.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "natureOfAssignmentName", "natureOfAssignment.natureOfAssignmentName");
	}

}
