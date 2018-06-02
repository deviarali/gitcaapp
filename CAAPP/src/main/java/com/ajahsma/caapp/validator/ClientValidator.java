package com.ajahsma.caapp.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ajahsma.caapp.dto.ClientDto;

@Component
public class ClientValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ClientDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object clientObject, Errors errors) {
		System.out.println("Inside validate()");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clientName", "client.firstname.requires", "Client Name Requires");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tradeName", "client.tradename.requires", "Trade name requires");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyStatusDto.companyStatusId", "client.companystatus.requires", "Company status requires");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clientMobile", "mobilenum.requires", "Mobile num requires");

		ClientDto clientDto = (ClientDto) clientObject;
		
		if(!StringUtils.hasText(clientDto.getClientName())) {
			errors.rejectValue("clientName", "client.clientName.required");
		}
		if(!StringUtils.hasText(clientDto.getTradeName())) {
			errors.rejectValue("tradeName", "client.tradeName.required");
		}
		if(clientDto.getCompanyStatusDto() == null || clientDto.getCompanyStatusDto().getCompanyStatusId() == null || clientDto.getCompanyStatusDto().getCompanyStatusId() == -1) {
			errors.rejectValue("companyStatusDto.companyStatusId", "client.company.required");
		}
		if(!StringUtils.hasText(clientDto.getClientMobile())) {
			errors.rejectValue("clientMobile", "client.clientMobile.required");
		}
		if(!StringUtils.hasText(clientDto.getClientEmail())) {
			errors.rejectValue("clientEmail", "client.clientEmail.required");
		}
		if(!StringUtils.hasText(clientDto.getAadharNumber())) {
			errors.rejectValue("aadharNumber", "client.aadharNumber.required");
		}
		if(clientDto.getClientTypeDto() == null || clientDto.getClientTypeDto().getClientTypeId() == null || clientDto.getClientTypeDto().getClientTypeId() == -1) {
			errors.rejectValue("clientTypeDto.clientTypeId", "client.clientTypeId.required");
		}
		if(clientDto.getNatureOfAssignmentList() == null || clientDto.getNatureOfAssignmentList().length ==0 ) {
			errors.rejectValue("natureOfAssignmentList", "client.natureOfAssignmentList.min.one.required");
		}

	}
}
