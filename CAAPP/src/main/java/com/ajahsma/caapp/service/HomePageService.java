/**
 * 
 */
package com.ajahsma.caapp.service;

import java.util.List;

import com.ajahsma.caapp.dto.HomePageDto;

/**
 * @author Dev
 *
 */
public interface HomePageService 
{
	public List<HomePageDto> getRecentClients();

}
