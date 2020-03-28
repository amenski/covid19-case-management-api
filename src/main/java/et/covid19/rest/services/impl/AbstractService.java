package et.covid19.rest.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.ConstantEnum;
import et.covid19.rest.dal.repositories.ConstantsEnumRepository;
import et.covid19.rest.dal.repositories.PuiInfoRepository;
import et.covid19.rest.dal.repositories.QuestionnierRepository;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;

@Service
public class AbstractService {
	
	@Autowired
	protected ConstantsEnumRepository constantsEnumRepository;
	
	@Autowired
	protected PuiInfoRepository puiInfoRepository;
	
	@Autowired
	protected QuestionnierRepository questionnierRepository;
	
	@EthLoggable
	protected List<ConstantEnum> getEnumByType(String type) throws EthException {
		List<ConstantEnum> result = new ArrayList<>();
		try{
			List<ConstantEnum> enums = constantsEnumRepository.findByEnumType(type);
			if(enums.isEmpty()) {
				throw EthExceptionEnums.CONSTANT_NOT_FOUND.get();
			}
			result.addAll(enums);
		} catch (Exception ex) {
			throw ex;
		}
		return result;
	}
	
	//do a set difference to validate input vs fetched
	@EthLoggable
	protected void validateInputEnumById(String type, Set<Integer> id) throws EthException {
		try{
			Set<Integer> foundIds = getEnumByType(type).stream().map(ConstantEnum::getEnumCode).collect(Collectors.toSet());
			if(!Sets.difference(id, foundIds).isEmpty())
				throw EthExceptionEnums.CONSTANT_NOT_FOUND.get();
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	protected boolean caseExists(String caseCode) {
		if(StringUtils.isBlank(caseCode))
			return true; //skip faking existence
		
		return (puiInfoRepository.findByCaseCode(caseCode) != null);
	}

}
