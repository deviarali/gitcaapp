/**
 * 
 */
package com.ajahsma.caapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dev
 *
 */

@Entity
@Table(name = "client_type")
public class ClientTypeModel extends AbstractIdDomain { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_type_id") 
	private int clientTypeId;
	
	@Column(name = "client_type_name")
	private String clientTypeName;

	public int getClientTypeId() {
		return clientTypeId;
	}

	public void setClientTypeId(int clientTypeId) {
		this.clientTypeId = clientTypeId;
	}
	
	public String getClientTypeName() {
		return clientTypeName;
	}

	public void setClientTypeName(String clientTypeName) {
		this.clientTypeName = clientTypeName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClientTypeModel [clientTypeId=" + clientTypeId + ", clientTypeName=" + clientTypeName + "]";
	}
	
	
	
}
