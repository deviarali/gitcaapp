/**
 * 
 */
package com.ajahsma.caapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ajahsma.caapp.dto.ApplicationUserDto;
import com.ajahsma.caapp.dto.UserRoleDto;
import com.ajahsma.caapp.model.UserRoleModel;
import com.ajahsma.caapp.service.ApplicationUserService;

/**
 * @author Dev
 *
 */

@Controller
@RequestMapping(value = "/caapp")
public class ApplicationUserController extends BaseController {
	
	@Autowired
	ApplicationUserService applicationUserService;

	@RequestMapping(value = "/applicationUser/applicationUserRegister", method = RequestMethod.POST)
	public ModelAndView homePage(@Valid @ModelAttribute("applicationUser") ApplicationUserDto applicationUser, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		applicationUserService.applicationUserRegister(applicationUser);

		model.addAttribute("alert_msg", "Application User registerd successfully");
		return new ModelAndView("applicationUserRegister", "applicationUser", applicationUser);

	}

	@RequestMapping(value = "/userRole/userRoleRegister", method = RequestMethod.POST)
	public ModelAndView homePage(@Valid @ModelAttribute("userRole") UserRoleDto userRole, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		applicationUserService.userRoleRegister(userRole);

		model.addAttribute("alert_msg", "User Role registerd successfully");
		return new ModelAndView("userRoleRegister", "userRole", userRole);

	}

	@RequestMapping(value = "/applicationUser", method = RequestMethod.GET)
	public ModelAndView navigateToApplicationUserRegister() {
		
		return new ModelAndView("applicationUserRegister", "applicationUser", new ApplicationUserDto());

	}

	@RequestMapping(value = "/userRole", method = RequestMethod.GET)
	public ModelAndView navigateToUserRole() {
		return new ModelAndView("userRoleRegister", "userRole", new UserRoleDto());
	}

	@ModelAttribute("userRoleList")
	private List<UserRoleDto> findUserRoleDtoList() {
		List<UserRoleDto> userRoleDtos = new ArrayList<>();
		List<UserRoleModel> userRoles = (List) applicationUserService.getAllDomain(UserRoleModel.class);
		if (!CollectionUtils.isEmpty(userRoles)) {
			for (UserRoleModel userRoleModel : userRoles) {
				UserRoleDto userRoleDto = new UserRoleDto();
				userRoleDto.setId(userRoleModel.getId());
				userRoleDto.setRoleName(userRoleModel.getRoleName());
				userRoleDtos.add(userRoleDto);
			}
		}
		return userRoleDtos;
	}

}
