package et.covid19.rest.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import et.covid19.rest.dal.model.RumorReport;
import et.covid19.rest.swagger.model.ModelRumor;
import et.covid19.rest.swagger.model.RequestSaveRumor;

@Mapper
public interface RumorReportMapper {

	RumorReportMapper INSTANCE = Mappers.getMapper(RumorReportMapper.class);
	
	RumorReport modelToEntity(ModelRumor model);

	ModelRumor entityToModel(RumorReport entity);
	
	RumorReport modelToEntity(RequestSaveRumor model);
}
