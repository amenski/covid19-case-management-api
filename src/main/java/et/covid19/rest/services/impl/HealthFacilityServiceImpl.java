package et.covid19.rest.services.impl;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

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
import et.covid19.rest.swagger.model.ModelHealthFacility;
import et.covid19.rest.swagger.model.ModelHealthFacilityList;
import et.covid19.rest.swagger.model.RequestSaveFacility;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;
import et.covid19.rest.util.mappers.HealthFacilityMapper;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HealthFacilityServiceImpl extends AbstractService implements IHealthFacilityService {

    @Autowired
	private HealthFacilityRepository healthFacilityRepository;

    @Override
    @EthLoggable
    @Transactional(rollbackFor = Exception.class)
    public boolean registerNewFacility(RequestSaveFacility newFacility) throws EthException {
        try{
        	if(!newFacility.getFacilities().isEmpty()) {
	        	List<HealthFacility> facilityList = new ArrayList<>();
	        	OffsetDateTime now = OffsetDateTime.now();
	        	String user = getCurrentLoggedInUserId();
	        	newFacility.getFacilities().stream().forEach(val -> {
		        	HealthFacility entity = HealthFacilityMapper.INSTANCE.modelToEntity(val);
		        	entity.setModifiedBy(user);
		        	entity.setModifiedDate(now);
		        	
		        	facilityList.add(entity);
	        	});
	        	
	            healthFacilityRepository.saveAll(facilityList);
        	}
            return true;
        } catch(ConstraintViolationException | DataIntegrityViolationException e) {
            throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
        } catch (Exception ex) {
            throw ex;
        }
    }

	@Override
	public ModelHealthFacility getHealthFacility(Integer id) throws EthException {
		try {
			if (id == null)
				return null;

			HealthFacility entity = healthFacilityRepository.findById(id).orElseThrow(EthExceptionEnums.HEALTH_FACILITY_NOT_FOUND);
			return HealthFacilityMapper.INSTANCE.entityToModel(entity);
		} catch (ConstraintViolationException | DataIntegrityViolationException e) {
			throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public ModelHealthFacilityList getAllHealthFacility() throws EthException {
		try {
			List<HealthFacility> entity = healthFacilityRepository.findAll();
			ModelHealthFacilityList facilityList = new ModelHealthFacilityList();
			entity.stream().forEach(val -> {
				facilityList.addFacilitiesItem(HealthFacilityMapper.INSTANCE.entityToModel(val));
			});
			return facilityList;
		} catch (ConstraintViolationException | DataIntegrityViolationException e) {
			throw EthExceptionEnums.VALIDATION_EXCEPTION.get();
		} catch (Exception ex) {
			throw ex;
		}
	}
}
