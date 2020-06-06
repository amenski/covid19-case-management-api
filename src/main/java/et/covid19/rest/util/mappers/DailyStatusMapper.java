package et.covid19.rest.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import et.covid19.rest.dal.model.CaseStat;
import et.covid19.rest.swagger.model.ModelDailyCaseStatus;

@Mapper
public interface DailyStatusMapper {

	DailyStatusMapper INSTANCE = Mappers.getMapper(DailyStatusMapper.class);
	
	@Mappings({
		@Mapping(target = "seriousCriticalCases", source = "criticalCases"),
	})
	CaseStat dtoToEntity(ModelDailyCaseStatus model);
	
	@Mappings({
		@Mapping(target = "criticalCases", source = "seriousCriticalCases"),
	})
	ModelDailyCaseStatus entityToDto(CaseStat entity);
}
