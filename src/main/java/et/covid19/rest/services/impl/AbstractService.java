package et.covid19.rest.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.ConstantEnum;
import et.covid19.rest.dal.repositories.ConstantsEnumRepository;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;

@Service
public class AbstractService {
	
	@Autowired
	protected ConstantsEnumRepository constantsEnumRepository;
	
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
	protected boolean validateInputEnumById(String type, Set<Integer> id) throws EthException {
		try{
			Set<Integer> foundIds = getEnumByType(type).stream().map(ConstantEnum::getEnumCode).collect(Collectors.toSet());
			return Sets.difference(id, foundIds).isEmpty();
		} catch (Exception ex) {
			throw ex;
		}
	}

}
