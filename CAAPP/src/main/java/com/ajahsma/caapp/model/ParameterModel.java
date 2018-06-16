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
@Entity(name = "Parameter")
@Table(name = "parameter")
public class ParameterModel extends AbstractIdDomain { 

	private String parameterName;
	private String description;
	private String value;
	
	@Column(name = "name", nullable = false)
	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "value", nullable = true)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
