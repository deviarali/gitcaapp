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
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ajahsma.caapp.dto.ApplicationUserDto;
import com.ajahsma.caapp.dto.UserRoleDto;
import com.ajahsma.caapp.exception.BusinessException;
import com.ajahsma.caapp.model.ApplicationUserModel;
import com.ajahsma.caapp.model.UserRoleModel;
import com.ajahsma.caapp.service.ApplicationUserService;
import com.ajahsma.caapp.validator.ApplicationUserValidator;
import com.ajahsma.caapp.validator.UserRoleValidator;

/**
 * @author Dev
 *
 */

@Controller
@RequestMapping(value = "/caapp")
public class ApplicationUserController extends BaseController {
	
	@Autowired
	ApplicationUserService applicationUserService;
	
	@Autowired
	UserRoleValidator validator;
	
	@Autowired
	ApplicationUserValidator applicationUserValidator;
	
	@RequestMapping(value = "/applicationUser", method = RequestMethod.GET)
	public String navigateToApplicationUser(Model model) {
		
		List<ApplicationUserDto> applicationUsers = applicationUserService.findApplicationUserDtoList();
		
		model.addAttribute("applicationUsers", applicationUsers);
//		model.addAttribute("applicationUser", new ApplicationUserDto());

		return "applicationUser";
	}

	@RequestMapping(value = "/applicationUser/createApplicationUser", method = RequestMethod.GET)
	public ModelAndView navigateToApplicationUserRegister() {
		
		ApplicationUserDto applicationUserDto = new ApplicationUserDto();
		applicationUserDto.setIsActive(Boolean.TRUE);

		return new ModelAndView("applicationUserRegister", "applicationUser", applicationUserDto);

	}
	
	@RequestMapping(value = "/applicationUser/{id}", method = RequestMethod.GET)
	private String getApplicationUser(Model model, @PathVariable("id") Long id) {
		
		ApplicationUserDto applicationUserDto = applicationUserService.getApplicationUserDto(id);
		
		model.addAttribute("applicationUser", applicationUserDto);
		return "applicationUserRegister";
	}
	
	@RequestMapping(value = "/applicationUser/delete/{id}", method = RequestMethod.GET)
	private String deleteApplicationUser(Model model, @PathVariable("id") Long id) {
		
		ApplicationUserModel applicationUser = (ApplicationUserModel) applicationUserService.getDomain(ApplicationUserModel.class, id);
		
		applicationUserService.deleteDomain(applicationUser);
		
		List<ApplicationUserDto> applicationUsers = applicationUserService.findApplicationUserDtoList();
		
		model.addAttribute("applicationUsers", applicationUsers);
		model.addAttribute("applicationUser", new ApplicationUserDto());
		
		return "redirect:/caapp/applicationUser";
	}

	@RequestMapping(value = "/applicationUser/applicationUserRegister", method = RequestMethod.POST)
	public ModelAndView homePage(@Valid @ModelAttribute("applicationUser") ApplicationUserDto applicationUser, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		try {
			applicationUserValidator.validate(applicationUser, bindingResult);
			if(bindingResult.hasErrors())
			{
				model.addAttribute("alert_msg", "Oops! something went wrong...");
				return new ModelAndView("applicationUserRegister");
			}
			
			if(applicationUser.getId() != null) {
				applicationUserService.updateApplicationUser(applicationUser);
			}
			else {
				applicationUserService.saveApplicationUser(applicationUser);
			}
				
			model.addAttribute("alert_msg", "Application User registerd successfully");
		} catch (BusinessException e) {
			model.addAttribute("alert_msg", "Oops! " + e.getMessage());
		} catch (Exception e) {
			model.addAttribute("alert_msg", "Oops! Something went wrong please checck logs");
		}
		return new ModelAndView("applicationUserRegister", "applicationUser", applicationUser);

	}

	@RequestMapping(value = "/userRole", method = RequestMethod.GET)
	public ModelAndView navigateToUserRole() {
		return new ModelAndView("userRoleRegister", "userRole", new UserRoleDto());
	}
	
	@RequestMapping(value = "/userRole/userRoleRegister", method = RequestMethod.POST)
	public ModelAndView homePage(@Valid @ModelAttribute("userRole") UserRoleDto userRole, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		try {
			validator.validate(userRole, bindingResult);
			if(bindingResult.hasErrors())
			{
				model.addAttribute("userRole", userRole);
				return new ModelAndView("userRoleRegister");
			}
			if(StringUtils.hasText(userRole.getRoleName()) && userRole.getRoleName().contains(" ")) {
				userRole.setRoleName("ROLE_" + userRole.getRoleName().toUpperCase().replaceAll(" ", "_"));
			}

			applicationUserService.userRoleRegister(userRole);

			model.addAttribute("alert_msg", "User Role registerd successfully");
		} catch (Exception e) {
			model.addAttribute("userRole", userRole);
			model.addAttribute("alert_msg", "Oops! " + e.getMessage());
		}
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
				userRoleDto.setDescription(userRoleModel.getDescription());
				
				userRoleDtos.add(userRoleDto);
			}
		}
		return userRoleDtos;
	}

}
