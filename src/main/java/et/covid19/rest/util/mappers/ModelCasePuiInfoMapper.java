package et.covid19.rest.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import et.covid19.rest.dal.model.PuiInfo;
import et.covid19.rest.swagger.model.ModelCase;
import et.covid19.rest.swagger.model.RequestSaveCase;

@Mapper
public interface ModelCasePuiInfoMapper {

	ModelCasePuiInfoMapper INSTANCE = Mappers.getMapper(ModelCasePuiInfoMapper.class ); 
	
	//ignore auto_generated values
	@Mapping(target = "id", ignore=true)
	@Mapping(target = "caseCode", ignore=true)
	PuiInfo modelCaseToPuiInfoMapper(ModelCase newCase);
	
	ModelCase puiInfoToModelCaseMapper(PuiInfo puiInfo);
	
	PuiInfo modelCaseToPuiInfoMapper(RequestSaveCase newCase); //similar fields with ModelCase
}
