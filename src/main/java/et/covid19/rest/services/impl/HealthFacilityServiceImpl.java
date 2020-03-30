package et.covid19.rest.services.impl;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.HealthFacility;
import et.covid19.rest.dal.repositories.HealthFacilityRepository;
import et.covid19.rest.services.IHealthFacilityService;
import et.covid19.rest.swagger.model.RequestSaveFacility;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;
import et.covid19.rest.util.mappers.HealthFacilityMapper;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HealthFacilityServiceImpl implements IHealthFacilityService {

    @Autowired
	private HealthFacilityRepository healthFacilityRepository;

    @Override
    @EthLoggable
    @Transactional(rollbackFor = Exception.class)
    public boolean registerNewFacility(RequestSaveFacility newFacility) throws EthException {
        try{
        	HealthFacility entity = HealthFacilityMapper.INSTANCE.modelToEntity(newFacility);
            healthFacilityRepository.save(entity);
            return true;
        } catch(ConstraintViolationException | DataIntegrityViolationException e) {
            throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
