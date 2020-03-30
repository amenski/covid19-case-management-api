package et.covid19.rest.services.impl;

import java.time.OffsetDateTime;
import java.util.UUID;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableSet;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.ConstantEnum;
import et.covid19.rest.dal.model.PuiInfo;
import et.covid19.rest.services.ICaseService;
import et.covid19.rest.swagger.model.ModelCase;
import et.covid19.rest.swagger.model.RequestSaveCase;
import et.covid19.rest.util.EthConstants;
import et.covid19.rest.util.GeneralUtils;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;
import et.covid19.rest.util.mappers.PuiInfoMapper;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CaseServiceImpl extends AbstractService implements ICaseService {

	@Override
	@EthLoggable
	@Transactional(rollbackFor = Exception.class)
	public boolean registerNewCase(RequestSaveCase newCase) throws EthException {
		try{
			//validate parent case
			if(!caseExists(newCase.getParentCaseCode()))
				throw EthExceptionEnums.CASE_NOT_FOUND.get().message("Parent case not found.");
			
			PuiInfo entity = PuiInfoMapper.INSTANCE.modelCaseToPuiInfoMapper(newCase);
			saveAndGetPuiInfo(entity);
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
			
			return PuiInfoMapper.INSTANCE.puiInfoToModelCaseMapper(info);
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
			
			info.setStatus(new ConstantEnum(status));
			validateInputEnumById(EthConstants.CONST_TYPE_STATUS, 
					ImmutableSet.of(GeneralUtils.defaultIfNull(info::setStatus, info::getStatus, EthConstants.CONST_STATUS_NA).getEnumCode()));
			
			//FIXME add work flow check
			
			info.setModifiedBy(getCurrentLoggedInUserId());
			info.setModifiedDate(OffsetDateTime.now());
			
			puiInfoRepository.save(info);
			return true;
		} catch (Exception ex) {
			throw ex;
		}
	}

}
