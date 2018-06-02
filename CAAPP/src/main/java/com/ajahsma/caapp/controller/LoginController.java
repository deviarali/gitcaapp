/**
 * 
 */
package com.ajahsma.caapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author SHARAN A
 *
 */

@Controller
@RequestMapping(value = "/")
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String homePage() {
		return "login";
	}
}
