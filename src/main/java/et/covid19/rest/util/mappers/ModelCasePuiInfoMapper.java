package et.covid19.rest.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import et.covid19.rest.dal.model.PuiInfo;
import et.covid19.rest.swagger.model.ModelCase;

@Mapper
public interface ModelCasePuiInfoMapper {

	ModelCasePuiInfoMapper INSTANCE = Mappers.getMapper(ModelCasePuiInfoMapper.class ); 
	 
	@Mappings({
		@Mapping(target="presumptiveResult", source="presumptiveResult.result"),
		@Mapping(target="confirmedResult", source="confirmedResult.result"),
		@Mapping(target="identifiedBy", source="identifiedBy.result"),
	})
	PuiInfo modelCaseToPuiInfoMapper(ModelCase newCase);

	@Mappings({
		@Mapping(target="presumptiveResult.result", source="presumptiveResult"),
		@Mapping(target="confirmedResult.result", source="confirmedResult"),
		@Mapping(target="identifiedBy.result", source="identifiedBy"),
	})
	ModelCase puiInfoToModelCaseMapper(PuiInfo puiInfo);
}
