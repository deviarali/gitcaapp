package com.ajahsma.caapp.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ajahsma.caapp.dto.ApplicationUserDto;
import com.ajahsma.caapp.service.ApplicationUserService;

@Component
public class ApplicationUserValidator implements Validator {

	@Autowired
	ApplicationUserService applicationUserService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ApplicationUserDto.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		if(object instanceof ApplicationUserDto) {
			ApplicationUserDto applicationUserDto = (ApplicationUserDto) object;
			if(applicationUserDto.getId() == null && StringUtils.hasText(applicationUserDto.getUserName())) {

				Integer countExists = applicationUserService.getApplicationUserCount(applicationUserDto.getUserName(), null);
				
				if(countExists > 0) {
					errors.rejectValue("userName", "application.userName.alreadyExists", "The user already exists for same user name");
				}
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "application.user.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "application.user.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userRoles", "application.user.userroles");
	}

}
