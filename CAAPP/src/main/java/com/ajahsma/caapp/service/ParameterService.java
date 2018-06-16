/**
 * 
 */
package com.ajahsma.caapp.service;

import java.util.List;

import com.ajahsma.caapp.dto.ParameterDto;
import com.ajahsma.caapp.model.ParameterModel;

/**
 * @author Dev
 * @param <E>
 *
 */
public interface ParameterService extends DefaultManager {

	public ParameterModel getParameter(String parameterName);

	public List<ParameterDto> findParameterDtoList();

	public void saveParameter(ParameterDto parameter) throws Exception;

	public void updateParameter(ParameterDto parameter) throws Exception;

	public ParameterDto getParameterDto(Long id);
	
	public ParameterDto getParameterDto(String parameterName);
	
	public <T> T getParameterValue(String applicationId, Class<T> parameterType);
	
}
