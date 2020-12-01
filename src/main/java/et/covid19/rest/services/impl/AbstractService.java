package et.covid19.rest.services.impl;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import et.covid19.rest.dal.model.ConstantEnum;
import et.covid19.rest.dal.model.ContactTracing;
import et.covid19.rest.dal.model.PuiInfo;
import et.covid19.rest.dal.repositories.ConstantsEnumRepository;
import et.covid19.rest.dal.repositories.ContactTracingRepository;
import et.covid19.rest.dal.repositories.HealthFacilityRepository;
import et.covid19.rest.dal.repositories.PuiInfoRepository;
import et.covid19.rest.dal.repositories.QuestionnierRepository;
import et.covid19.rest.util.EthConstants;
import et.covid19.rest.util.GeneralUtils;
import et.covid19.rest.util.LogConstants;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AbstractService {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected ConstantsEnumRepository constantsEnumRepository;
	
	@Autowired
	protected PuiInfoRepository puiInfoRepository;
	
	@Autowired
	protected QuestionnierRepository questionnierRepository;
	
	@Autowired
	protected HealthFacilityRepository healthFacilityRepository;
	
	@Autowired
	private ContactTracingRepository contactTracingRepository;
	
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
	protected void validateInputEnumById(String type, Set<Integer> id) throws EthException {
	    String methodName = "validateInputEnumById()";
    	Set<Integer> foundIds = getEnumByType(type).stream().map(ConstantEnum::getEnumCode).collect(Collectors.toSet());
    	if(!Sets.difference(id, foundIds).isEmpty()) {
    	    logger.error("{} failed to validate ids: [{}] against: [{}]", methodName, id, foundIds);
    		throw EthExceptionEnums.CONSTANT_NOT_FOUND.get();
    	}
	}
	
	protected PuiInfo getParentCase(String caseCode) {
		if(StringUtils.isBlank(caseCode))
			return null;
		
		return puiInfoRepository.findByCaseCode(caseCode);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public PuiInfo saveAndGetPuiInfo(PuiInfo entity) throws EthException {
	    String methodName = "saveAndGetPuiInfo()";
        logger.info(LogConstants.PARAMETER_2, methodName, LogConstants.METHOD_START);
        try{
    		OffsetDateTime timeNow = OffsetDateTime.now();
    		validateInputEnumById(EthConstants.CONST_TYPE_TEST_RESULT, ImmutableSet.of(
    				GeneralUtils.defaultIfNull(entity::setPresumptiveResult, entity::getPresumptiveResult, EthConstants.CONST_TEST_PENDING).getEnumCode(),
    				GeneralUtils.defaultIfNull(entity::setConfirmedResult, entity::getConfirmedResult, EthConstants.CONST_TEST_PENDING).getEnumCode()));
    		validateInputEnumById(EthConstants.CONST_TYPE_IDENTIFIED_BY, ImmutableSet.of(
    				GeneralUtils.defaultIfNull(entity::setIdentifiedBy, entity::getIdentifiedBy, EthConstants.CONST_IDENTIFIED_BY_CLINICAL_EVAL).getEnumCode()));
    		validateInputEnumById(EthConstants.CONST_TYPE_STATUS, ImmutableSet.of(GeneralUtils.defaultIfNull(entity::setStatus, entity::getStatus, EthConstants.CONST_STATUS_NA).getEnumCode()));
    		
    		if(entity.getAdmittedToFacility() != null) {
    			healthFacilityRepository.findById(entity.getAdmittedToFacility()).orElseThrow(EthExceptionEnums.HEALTH_FACILITY_NOT_FOUND);
    		}
    		
    		if(entity.getReportingDate() == null) {
    			entity.setReportingDate(timeNow);
    		}
    		entity.setCaseCode(GeneralUtils.generateRandomCode(entity.getRegion()));
    		entity.setModifiedDate(timeNow);
    		entity.setModifiedBy(getCurrentLoggedInUserId());
    		
    		return puiInfoRepository.saveAndFlush(entity);
        } catch(EthException ex) {
            logger.error(LogConstants.PARAMETER_2, methodName, ex.getMessage());
            throw ex;
        } catch(Exception ex) {
            logger.error(LogConstants.PARAMETER_2, methodName, ex);
            throw ex;
        } finally {
            logger.info(LogConstants.PARAMETER_2, methodName, LogConstants.METHOD_END);
        }
	}

	@Transactional(rollbackFor = Exception.class)
	public void addContactTracingInfo(String parentCode, String childCode) {
	    String methodName = "addContactTracingInfo()";
        logger.info(LogConstants.PARAMETER_2, methodName, LogConstants.METHOD_START);
        try{
            if(StringUtils.isAnyEmpty(parentCode, childCode)) 
                return;
		
    		ContactTracing parent = contactTracingRepository.findById(parentCode).orElse(new ContactTracing());
    		ContactTracing child = new ContactTracing();
    		child.setParentCaseCode(childCode);
    		
    		parent.setParentCaseCode(parentCode);
    		parent.setModifiedBy(getCurrentLoggedInUserId());
    		parent.setModifiedDate(OffsetDateTime.now());
    		parent.getChildren().add(child);
    		
    		contactTracingRepository.save(parent); 
		} catch(Exception ex) {
            logger.error(LogConstants.PARAMETER_2, methodName, ex);
            throw ex;
        } finally {
            logger.info(LogConstants.PARAMETER_2, methodName, LogConstants.METHOD_END);
        }
	}
	
	protected String getCurrentLoggedInUserId() {
		String userId = null;
		SecurityContext context = SecurityContextHolder.getContext();
		if(Objects.nonNull(context.getAuthentication())) {
			userId = context.getAuthentication().getPrincipal().toString();
		}
		return userId;
	}
}
