/**
 * 
 */
package com.ajahsma.caapp.service;

import java.util.List;

import com.ajahsma.caapp.dto.ApplicationUserDto;
import com.ajahsma.caapp.dto.UserRoleDto;

/**
 * @author Dev
 * @param <E>
 *
 */
public interface ApplicationUserService extends DefaultManager {

	public List<ApplicationUserDto> findApplicationUserDtoList();

	public void applicationUserRegister(ApplicationUserDto applicationUser);

	public void userRoleRegister(UserRoleDto userRole);

}
