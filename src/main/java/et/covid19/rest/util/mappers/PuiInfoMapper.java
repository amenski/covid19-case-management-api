package et.covid19.rest.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import et.covid19.rest.dal.model.PuiInfo;
import et.covid19.rest.swagger.model.ModelCase;
import et.covid19.rest.swagger.model.RequestSaveCase;
import et.covid19.rest.swagger.model.RequestSaveFollowUp;

@Mapper
public interface PuiInfoMapper {

	PuiInfoMapper INSTANCE = Mappers.getMapper(PuiInfoMapper.class ); 
	
	//ignore auto_generated values
	@Mappings({
		@Mapping(target = "id", ignore=true),
		@Mapping(target = "caseCode", ignore=true),
		@Mapping(target = "presumptiveResult.enumCode", source = "presumptiveResult.id"),
		@Mapping(target = "confirmedResult.enumCode", source = "confirmedResult.id"),
		@Mapping(target = "identifiedBy.enumCode", source = "identifiedBy.id"),
		@Mapping(target = "status.enumCode", source = "status.id"),
		
	})
	PuiInfo modelCaseToPuiInfoMapper(ModelCase newCase);
	
	@Mappings({
		@Mapping(target = "id", ignore=true),
		@Mapping(target = "caseCode", ignore=true),
		@Mapping(target = "presumptiveResult.id", source = "presumptiveResult.enumCode"),
		@Mapping(target = "presumptiveResult.value", source = "presumptiveResult.enumName"),
		@Mapping(target = "confirmedResult.id", source = "confirmedResult.enumCode"),
		@Mapping(target = "confirmedResult.value", source = "confirmedResult.enumName"),
		@Mapping(target = "identifiedBy.id", source = "identifiedBy.enumCode"),
		@Mapping(target = "identifiedBy.value", source = "identifiedBy.enumName"),
		@Mapping(target = "status.id", source = "status.enumCode"),
		@Mapping(target = "status.value", source = "status.enumName"),
		
	})
	ModelCase puiInfoToModelCaseMapper(PuiInfo puiInfo);
	
	@Mappings({
		@Mapping(target = "presumptiveResult.enumCode", source = "presumptiveResult.id"),
		@Mapping(target = "confirmedResult.enumCode", source = "confirmedResult.id"),
		@Mapping(target = "identifiedBy.enumCode", source = "identifiedBy.id"),
		@Mapping(target = "status.enumCode", source = "status.id"),
		
	})
	PuiInfo modelCaseToPuiInfoMapper(RequestSaveCase newCase); //similar fields with ModelCase

	@Mappings({
		@Mapping(target = "presumptiveResult.enumCode", source = "presumptiveResult.id"),
		@Mapping(target = "confirmedResult.enumCode", source = "confirmedResult.id"),
		@Mapping(target = "identifiedBy.enumCode", source = "identifiedBy.id"),
		@Mapping(target = "status.enumCode", source = "status.id"),
		
	})
	PuiInfo modelFollowupToPuiInfoMapper(RequestSaveFollowUp body);
}
