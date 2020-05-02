package et.covid19.rest.services.impl;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.ImmutableSet;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.ConstantEnum;
import et.covid19.rest.dal.model.HealthFacility;
import et.covid19.rest.dal.model.PuiInfo;
import et.covid19.rest.dal.util.GeneralQueryBuilder;
import et.covid19.rest.services.ICaseService;
import et.covid19.rest.swagger.model.ModelCase;
import et.covid19.rest.swagger.model.ModelCaseList;
import et.covid19.rest.swagger.model.ModelEnumIdValue;
import et.covid19.rest.swagger.model.RequestSaveCase;
import et.covid19.rest.util.EthConstants;
import et.covid19.rest.util.GeneralUtils;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;
import et.covid19.rest.util.mappers.PuiInfoMapper;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CaseServiceImpl extends AbstractService implements ICaseService {

    @Autowired
    private GeneralQueryBuilder queryBuilder;
    
	@Override
	@EthLoggable
	@Transactional(rollbackFor = Exception.class)
	public String registerNewCase(RequestSaveCase newCase) throws EthException {
		try{
			//validate parent case
			PuiInfo parentCase = getParentCase(newCase.getParentCaseCode()); 
			if(!StringUtils.isBlank(newCase.getParentCaseCode()) && Objects.isNull(parentCase))
				throw EthExceptionEnums.CASE_NOT_FOUND.get().message("Parent case not found.");
			
			PuiInfo entity = PuiInfoMapper.INSTANCE.modelCaseToPuiInfoMapper(newCase);
			if(parentCase != null) {
				entity.setParentCaseCode(parentCase.getCaseCode());
			}
			if(StringUtils.isBlank(entity.getRegion()))
			    throw EthExceptionEnums.REGION_EMPTY_EXCEPTION.get();
			
			entity = saveAndGetPuiInfo(entity);
			if(Objects.nonNull(parentCase)) {
			    addContactTracingInfo(parentCase.getCaseCode(), entity.getCaseCode());
			}
			return entity.getCaseCode();
		} catch(ConstraintViolationException | DataIntegrityViolationException e) {
			throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	@EthLoggable
	public ModelCase getModelCase(String caseCode) throws EthException {
		try {
		    if(StringUtils.isBlank(caseCode))
		        return null;
		    
			PuiInfo info = puiInfoRepository.findByCaseCode(caseCode);
			if(info == null)
				throw EthExceptionEnums.CASE_NOT_FOUND.get();
			
			ModelCase modelCase = PuiInfoMapper.INSTANCE.puiInfoToModelCaseMapper(info);
			if(modelCase.getAdmittedToFacility() != null && modelCase.getAdmittedToFacility().getId() != null) {
				HealthFacility facility = healthFacilityRepository.findById(info.getAdmittedToFacility()).orElseThrow(EthExceptionEnums.HEALTH_FACILITY_NOT_FOUND);
				modelCase.admittedToFacility(new ModelEnumIdValue()
													.id(facility.getId())
													.value(facility.getName()));
			}
			return modelCase;
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
			validateInputEnumById(EthConstants.CONST_TYPE_TEST_RESULT, 
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

    @Override
    @EthLoggable
    public ModelCaseList searchCase(Integer confirmedResult, Integer status, String region, String recentTravelTo, String patientName) 
            throws EthException {
        try {
            ModelCaseList modelCaseList = new ModelCaseList();
            if ((confirmedResult == null || Integer.signum(confirmedResult) == -1)
                    && (status == null || Integer.signum(status) == -1)
                    && StringUtils.isAllBlank(region, recentTravelTo) 
                    && StringUtils.isBlank(patientName))
                return modelCaseList;

            List<PuiInfo> puiList = queryBuilder.buildCaseSearchCriteria(confirmedResult, status, region, recentTravelTo, patientName);
            return getCaseList(puiList);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    @Override
    @EthLoggable
    public ModelCaseList getAllCases(Integer page) throws EthException {
        try {
            if(page == null || Integer.signum(page) != 1) {
                page = 0;
            }
            ModelCaseList caseList = new ModelCaseList();
            Pageable countItems = PageRequest.of( (EthConstants.FETCH_SIZE * page), EthConstants.FETCH_SIZE);
            Page<PuiInfo> infoList = puiInfoRepository.findAll(countItems);
            if(Integer.signum(infoList.getSize()) != 1)
                return caseList;
                
            return getCaseList(infoList.getContent());
        } catch (Exception ex) {
            throw ex;
        }
    }

    private ModelCaseList getCaseList(List<PuiInfo> puiList) {
        ModelCaseList modelCaseList = new ModelCaseList();
        List<ModelCase> cases = new ArrayList<>();
        //instead of foreign key join to healthFacility, convert id to id,value here
        Map<Integer, HealthFacility> facilitiesMap = healthFacilityRepository.findAll().stream().collect(Collectors.toMap(HealthFacility::getId, Function.identity()));
        for (PuiInfo info : puiList) {
            ModelCase model = PuiInfoMapper.INSTANCE.entityToModelCaseForSearch(info);
            model.setAdmittedToFacility(new ModelEnumIdValue()
                    .id(info.getAdmittedToFacility())
                    .value(facilitiesMap.getOrDefault(info.getAdmittedToFacility(), new HealthFacility()).getName()));
            cases.add(model);
        }
        return modelCaseList.cases(cases);
    }
}
