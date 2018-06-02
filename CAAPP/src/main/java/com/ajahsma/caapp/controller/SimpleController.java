/**
 * 
 */
package com.ajahsma.caapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author SHARAN A
 *
 */

@Controller
@RequestMapping(value = "/caapp")
public class SimpleController {

	@Autowired
	DiscoveryClient discoveryClient; 
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String homePage() {
		List list = discoveryClient.getInstances("EMPLOYEE-PRODUCER");
		return "login";
	}
}
