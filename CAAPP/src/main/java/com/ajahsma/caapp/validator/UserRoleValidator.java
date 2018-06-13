package com.ajahsma.caapp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ajahsma.caapp.dto.UserRoleDto;
import com.ajahsma.caapp.model.UserRoleModel;

@Component
public class UserRoleValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRoleDto.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleName", "role.rolename.required");
		UserRoleDto userRoleDto = (UserRoleDto) object;
		if(null != userRoleDto && !userRoleDto.getRoleName().trim().startsWith("ROLE_") && userRoleDto.getRoleName().trim().length() >= 1)
		{
			errors.rejectValue("roleName", "role.rolename.invalid");
		}
	}

}
