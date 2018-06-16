package com.ajahsma.caapp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ajahsma.caapp.dto.ParameterDto;

@Component
public class ParameterValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ParameterDto.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "parameterName", "parameter.name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "parameter.description.required");
	}

}
