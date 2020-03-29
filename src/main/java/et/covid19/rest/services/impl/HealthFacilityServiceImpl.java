package et.covid19.rest.services.impl;

import com.google.common.collect.ImmutableSet;
import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.PuiInfo;
import et.covid19.rest.dal.repositories.HealthFacilityRepository;
import et.covid19.rest.services.IHealthFacilityService;
import et.covid19.rest.swagger.model.ModelHealthFacility;
import et.covid19.rest.swagger.model.RequestSaveFacility;
import et.covid19.rest.util.EthConstants;
import et.covid19.rest.util.LogConstants;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;
import et.covid19.rest.util.mappers.ModelCasePuiInfoMapper;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.MDC;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
public class HealthFacilityServiceImpl implements IHealthFacilityService {

    final HealthFacilityRepository healthFacilityRepository;

    public HealthFacilityServiceImpl(HealthFacilityRepository healthFacilityRepository) {
        this.healthFacilityRepository = healthFacilityRepository;
    }

    @Override
    @EthLoggable
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
    public boolean registerNewFacility(RequestSaveFacility newFacility) throws EthException {
        try{
            healthFacilityRepository.save(newFacility);
            return true;
        } catch(ConstraintViolationException | DataIntegrityViolationException e) {
            throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
