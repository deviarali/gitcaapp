package com.ajahsma.caapp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ajahsma.caapp.dto.ApplicationUserDto;

@Component
public class ApplicationUserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ApplicationUserDto.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "application.user.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "application.user.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userRoles", "application.user.userroles");
	}

}
