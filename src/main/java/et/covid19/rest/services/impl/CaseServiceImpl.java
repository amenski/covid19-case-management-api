package et.covid19.rest.services.impl;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableSet;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.PuiInfo;
import et.covid19.rest.dal.repositories.PuiInfoRepository;
import et.covid19.rest.services.ICaseService;
import et.covid19.rest.swagger.model.ModelCase;
import et.covid19.rest.swagger.model.RequestSaveCase;
import et.covid19.rest.util.EthConstants;
import et.covid19.rest.util.LogConstants;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;
import et.covid19.rest.util.mappers.ModelCasePuiInfoMapper;

@Service
public class CaseServiceImpl extends AbstractService implements ICaseService {
	
	@Autowired
	private PuiInfoRepository puiInfoRepository;

	@Override
	@EthLoggable
	@Transactional(rollbackFor = Exception.class)
	public boolean registerNewCase(RequestSaveCase newCase) throws EthException {
		try{
			boolean isValid = validateInputEnumById(EthConstants.CONST_TYPE_TEST_RESULT, ImmutableSet.of(newCase.getPresumptiveResult(), newCase.getConfirmedResult()));
			isValid = (isValid && validateInputEnumById(EthConstants.CONST_TYPE_IDENTIFIED_BY, ImmutableSet.of(newCase.getIdentifiedBy())));
			
			if(!isValid)
				throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
			
			PuiInfo entity = ModelCasePuiInfoMapper.INSTANCE.modelCaseToPuiInfoMapper(newCase);
			entity.setCaseCode(MDC.get(LogConstants.UUID_KEY));
			entity.setModifiedDate(OffsetDateTime.now());
			entity.setReportingDate(newCase.getReportingDate() != null ? newCase.getReportingDate() : OffsetDateTime.now());
			puiInfoRepository.save(entity);
			return true;
		} catch(ConstraintViolationException | DataIntegrityViolationException e) {
			throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	@EthLoggable
	public ModelCase getModelCase(UUID case_code) throws EthException {
		try {
			PuiInfo info = puiInfoRepository.findByCaseCode(case_code.toString());
			if(info == null)
				throw EthExceptionEnums.CASE_NOT_FOUND.get();
			
			return ModelCasePuiInfoMapper.INSTANCE.puiInfoToModelCaseMapper(info);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	@EthLoggable
	@Transactional(rollbackFor = Exception.class)
	public boolean updateResult(String code, Integer status) throws EthException {
		try {
			PuiInfo info = puiInfoRepository.findByCaseCode(code);
			if(info == null)
				throw EthExceptionEnums.CASE_NOT_FOUND.get();
			
			if(!validateInputEnumById(EthConstants.CONST_TYPE_TEST_RESULT, ImmutableSet.of(status)))
				throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
			
			//FIXME add work flow check
			
			info.setConfirmedResult(String.valueOf(status));
			
			puiInfoRepository.save(info);
			return true;
		} catch (Exception ex) {
			throw ex;
		}
	}

}
