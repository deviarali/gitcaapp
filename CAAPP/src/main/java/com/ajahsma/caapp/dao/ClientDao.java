/**
 * 
 */
package com.ajahsma.caapp.dao;

import java.util.List;

import com.ajahsma.caapp.model.ClientModel;
import com.ajahsma.caapp.model.ClientTypeModel;
import com.ajahsma.caapp.model.CompanyStatusModel;
import com.ajahsma.caapp.model.NatureOfAssignmentModel;

/**
 * @author Dev
 *
 */
public interface ClientDao extends DefaultDao
{

	List<ClientTypeModel> getClientTypes();

	List<CompanyStatusModel> getCompanyStatus();

	List<NatureOfAssignmentModel> getNatureOfAssignments();

	List<ClientModel> getRecentClients();

	List<ClientModel> getAllClients();
	
}
