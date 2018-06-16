/**
 * 
 */
package com.ajahsma.caapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ajahsma.caapp.dto.ParameterDto;
import com.ajahsma.caapp.dto.UserRoleDto;
import com.ajahsma.caapp.model.ParameterModel;
import com.ajahsma.caapp.service.ParameterService;
import com.ajahsma.caapp.validator.ParameterValidator;
import com.ajahsma.caapp.validator.UserRoleValidator;

/**
 * @author Dev
 *
 */

@Controller
@RequestMapping(value = "/caapp")
public class ParameterController extends BaseController {
	
	@Autowired
	ParameterService parameterService;
	
	@Autowired
	UserRoleValidator validator;
	
	@Autowired
	ParameterValidator parameterValidator;
	
	@RequestMapping(value = "/parameter", method = RequestMethod.GET)
	public String navigateToParameter(Model model) {
		
		List<ParameterDto> parameters = parameterService.findParameterDtoList();
		
		model.addAttribute("parameterList", parameters);

		return "parameter";
	}

	@RequestMapping(value = "/parameter/createParameter", method = RequestMethod.GET)
	public ModelAndView navigateToParameterRegister() {
		
		return new ModelAndView("parameterRegister", "parameter", new ParameterDto());

	}
	
	@RequestMapping(value = "/parameter/{id}", method = RequestMethod.GET)
	private String getParameter(Model model, @PathVariable("id") Long id) {
		
		ParameterDto parameterDto = parameterService.getParameterDto(id);
		
		model.addAttribute("parameter", parameterDto);
		
		return "parameterRegister";
	}
	
	@RequestMapping(value = "/parameter/delete/{id}", method = RequestMethod.GET)
	private String deleteParameter(Model model, @PathVariable("id") Long id) {
		
		ParameterModel parameter = (ParameterModel) parameterService.getDomain(ParameterModel.class, id);
		
		parameterService.deleteDomain(parameter);
		
		List<ParameterDto> parameters = parameterService.findParameterDtoList();
		
		model.addAttribute("parameterList", parameters);
		model.addAttribute("parameter", new ParameterDto());
		
		return "redirect:/caapp/parameter";
	}

	@RequestMapping(value = "/parameter/parameterRegister", method = RequestMethod.POST)
	public ModelAndView homePage(@Valid @ModelAttribute("parameter") ParameterDto parameter, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		try {
			parameterValidator.validate(parameter, bindingResult);
			if(bindingResult.hasErrors())
			{
				model.addAttribute("alert_msg", "Oops! something went wrong...");
				return new ModelAndView("parameterRegister");
			}
			
			if(parameter.getId() != null) {
				parameterService.updateParameter(parameter);
				model.addAttribute("alert_msg", "Parameter Updated successfully");
			}
			else {
				parameterService.saveParameter(parameter);
				model.addAttribute("alert_msg", "Parameter added successfully");
			}
				
		} catch (Exception e) {
			model.addAttribute("alert_msg", "Oops! " + e.getMessage());
		}
		List<ParameterDto> parameters = parameterService.findParameterDtoList();
		model.addAttribute("parameterList", parameters);
		return new ModelAndView("parameter", "parameter", parameter);

	}

}
