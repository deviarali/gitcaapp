/**
 * 
 */
package com.ajahsma.caapp.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ajahsma.caapp.dao.ApplicationUserDao;
import com.ajahsma.caapp.dto.ApplicationUserDto;
import com.ajahsma.caapp.dto.UserRoleDto;
import com.ajahsma.caapp.exception.BusinessException;
import com.ajahsma.caapp.model.ApplicationUserModel;
import com.ajahsma.caapp.model.UserRoleModel;
import com.ajahsma.caapp.service.ApplicationUserService;

/**
 * @author Dev
 *
 */
@Service
public class ApplicationUserServiceImpl extends DefaultManagerImpl implements ApplicationUserService {

	@Autowired
	private ApplicationUserDao applicationUserDao;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
	public void setDefaultDao(ApplicationUserDao defaultDao) {
		this.defaultDao = defaultDao;
	}

	private ApplicationUserDao getApplicationUserDao() {
		return (ApplicationUserDao) getDefaultDao();
	}

	@Override
	public List<ApplicationUserDto> findApplicationUserDtoList() {
		
		List<ApplicationUserDto> applicationUserDtos = new ArrayList<>();
		
		List<ApplicationUserModel> applicationUsers = getApplicationUserDao().findApplicationUsers();
		
		if(!CollectionUtils.isEmpty(applicationUsers)) {
			for (ApplicationUserModel applicationUser : applicationUsers) {
				ApplicationUserDto applicationUserDto = convertApplicationUserModelToApplicationUserDto(applicationUser);
				applicationUserDtos.add(applicationUserDto);
			}
		}
		
		return applicationUserDtos;
	}

	@Override
	public void updateApplicationUser(ApplicationUserDto applicationUser) {
		Integer userCount = getApplicationUserDao().getApplicationUserCount(applicationUser.getUserName(), applicationUser.getId());
		if(userCount > 0) {
			throw new BusinessException("User already exists with user name");
		}
		ApplicationUserModel applicationUserModel = convertApplicationUserDtoToApplicationUserModel(applicationUser);
		
		this.updateDomain(applicationUserModel);
	}

	@Override
	public void saveApplicationUser(ApplicationUserDto applicationUser) throws Exception {
		Integer userCount = getApplicationUserDao().getApplicationUserCount(applicationUser.getUserName());
		if(userCount > 0) {
			throw new Exception("User already exists with user name");
		}
		ApplicationUserModel applicationUserModel = convertApplicationUserDtoToApplicationUserModel(applicationUser);
		
		this.saveDomain(applicationUserModel);
	}

	@Override
	public void userRoleRegister(UserRoleDto userRole) {
		
		UserRoleModel userRoleModel = new UserRoleModel();
		userRoleModel.setId(userRole.getId());
		userRoleModel.setRoleName(userRole.getRoleName());

		if(userRoleModel.getId() == null) {
			this.saveDomain(userRoleModel);
		}
		else {
			this.updateDomain(userRoleModel);
		}
	}

	@Override
	public ApplicationUserDto getApplicationUserDto(Long id) {
		ApplicationUserModel applicationUserModel= (ApplicationUserModel) this.getDomain(ApplicationUserModel.class, id);
		ApplicationUserDto applicationUserDto = convertApplicationUserModelToApplicationUserDto(applicationUserModel);
		
		
		return applicationUserDto;
		
	}

	private ApplicationUserModel convertApplicationUserDtoToApplicationUserModel(ApplicationUserDto applicationUser) {
		
		ApplicationUserModel applicationUserModel = new ApplicationUserModel();
		applicationUserModel.setId(applicationUser.getId());
		applicationUserModel.setUserName(applicationUser.getUserName());
		applicationUserModel.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
		applicationUserModel.setIsActive(applicationUser.getIsActive());
		applicationUserModel.setCreateDate(Calendar.getInstance());
		applicationUserModel.setLoginAttempts(0);
		
		if(applicationUser.getUserRoles() != null && applicationUser.getUserRoles().length > 0) {
			for (String userrRole : applicationUser.getUserRoles()) {
				UserRoleModel userRoleModel = new UserRoleModel();
				userRoleModel.setId(Long.valueOf(userrRole));
				applicationUserModel.addUserRole(userRoleModel);
			}
		}
		
		return applicationUserModel;
	}

	private ApplicationUserDto convertApplicationUserModelToApplicationUserDto(ApplicationUserModel applicationUser) {
		
		ApplicationUserDto applicationUserDto = new ApplicationUserDto();
		applicationUserDto.setId(applicationUser.getId());
		applicationUserDto.setUserName(applicationUser.getUserName());
		applicationUserDto.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
		applicationUserDto.setIsActive(applicationUser.getIsActive());
		applicationUserDto.setCreateDate(Calendar.getInstance());
		applicationUserDto.setLoginAttempts(0);
		
		if(!CollectionUtils.isEmpty(applicationUser.getUserRoles())) {
			String[] userRoles = new String[applicationUser.getUserRoles().size()];
			int index = 0;
			for (UserRoleModel userrRole : applicationUser.getUserRoles()) {
				userRoles[index] = userrRole.getId().toString();
				UserRoleDto userRoleDto = new UserRoleDto();
				userRoleDto.setId(userrRole.getId());
				userRoleDto.setRoleName(userrRole.getRoleName());
				applicationUserDto.addUserRole(userRoleDto);
				index++;
			}
			applicationUserDto.setUserRoles(userRoles);
		}
		
		return applicationUserDto;
	}

}
