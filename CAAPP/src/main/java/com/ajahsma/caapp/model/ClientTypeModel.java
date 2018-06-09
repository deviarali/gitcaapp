/**
 * 
 */
package com.ajahsma.caapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Dev
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "clienttype")
public class ClientTypeModel extends AbstractIdDomain { 
	
	private String clientTypeName;

	@Column(name = "name")
	public String getClientTypeName() {
		return clientTypeName;
	}

	public void setClientTypeName(String clientTypeName) {
		this.clientTypeName = clientTypeName;
	}

	@Override
	public String toString() {
		return "ClientTypeModel [clientTypeId=" + getId() + ", clientTypeName=" + clientTypeName + "]";
	}
	
	
	
}
