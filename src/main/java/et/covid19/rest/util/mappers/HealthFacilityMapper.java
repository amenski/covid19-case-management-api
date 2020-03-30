package et.covid19.rest.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import et.covid19.rest.dal.model.HealthFacility;
import et.covid19.rest.swagger.model.ModelHealthFacility;
import et.covid19.rest.swagger.model.RequestSaveFacility;

@Mapper
public interface HealthFacilityMapper {

	HealthFacilityMapper INSTANCE = Mappers.getMapper(HealthFacilityMapper.class);
	
	HealthFacility modelToEntity(ModelHealthFacility model);
	
	ModelHealthFacility entityToModel(HealthFacility entity);
	
	HealthFacility modelToEntity(RequestSaveFacility facilityModel);
}
