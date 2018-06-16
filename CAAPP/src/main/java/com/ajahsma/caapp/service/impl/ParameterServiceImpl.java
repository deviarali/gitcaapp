/**
 * 
 */
package com.ajahsma.caapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ajahsma.caapp.dao.ParameterDao;
import com.ajahsma.caapp.dto.ParameterDto;
import com.ajahsma.caapp.model.ParameterModel;
import com.ajahsma.caapp.service.ParameterService;

/**
 * @author Dev
 *
 */
@Service
public class ParameterServiceImpl extends DefaultManagerImpl implements ParameterService {

	@Autowired
	private ParameterDao parameterDao;

	@Autowired
	public void setDefaultDao(ParameterDao defaultDao) {
		this.defaultDao = defaultDao;
	}

	private ParameterDao getParameterDao() {
		return (ParameterDao) getDefaultDao();
	}

	@Override
	public ParameterModel getParameter(String parameterName) {
		return getParameterDao().getParameter(parameterName);
	}

	@Override
	public ParameterDto getParameterDto(String parameterName) {
		ParameterModel parameterModel = getParameter(parameterName);
		return convertParameterModelToParameterDto(parameterModel);
	}

	@Override
	public List<ParameterDto> findParameterDtoList() {

		List<ParameterDto> parameterDtos = new ArrayList<>();

		List<ParameterModel> parameters = (List) this.getAllDomain(ParameterModel.class);

		if (!CollectionUtils.isEmpty(parameters)) {
			for (ParameterModel parameter : parameters) {
				ParameterDto parameterDto = convertParameterModelToParameterDto(parameter);
				parameterDtos.add(parameterDto);
			}
		}

		return parameterDtos;
	}

	@Override
	public void updateParameter(ParameterDto parameter) {

		ParameterModel parameterModel = convertParameterDtoToParameterModel(parameter);

		this.updateDomain(parameterModel);
	}

	@Override
	public void saveParameter(ParameterDto parameter) throws Exception {

		ParameterModel parameterModel = convertParameterDtoToParameterModel(parameter);

		this.saveDomain(parameterModel);
	}

	@Override
	public ParameterDto getParameterDto(Long id) {
		ParameterModel parameterModel = (ParameterModel) this.getDomain(ParameterModel.class, id);
		ParameterDto parameterDto = convertParameterModelToParameterDto(parameterModel);

		return parameterDto;

	}

	private ParameterModel convertParameterDtoToParameterModel(ParameterDto parameter) {

		ParameterModel parameterModel = new ParameterModel();
		parameterModel.setId(parameter.getId());
		parameterModel.setParameterName(parameter.getParameterName());
		parameterModel.setValue(parameter.getValue());
		parameterModel.setDescription(parameter.getDescription());

		return parameterModel;
	}

	private ParameterDto convertParameterModelToParameterDto(ParameterModel parameter) {

		ParameterDto parameterDto = new ParameterDto();
		parameterDto.setId(parameter.getId());
		parameterDto.setParameterName(parameter.getParameterName());
		parameterDto.setValue(parameter.getValue());
		parameterDto.setDescription(parameter.getDescription());

		return parameterDto;
	}

	@Override
	public <T> T getParameterValue(String parameterName, Class<T> parameterType) {
		ParameterDto parameterDto = getParameterDto(parameterName);
			
		return (T) parameterDto.getValue();
	}

}
