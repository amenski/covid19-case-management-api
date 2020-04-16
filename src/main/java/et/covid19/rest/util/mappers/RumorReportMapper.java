package et.covid19.rest.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import et.covid19.rest.dal.model.RumorReport;
import et.covid19.rest.swagger.model.ModelRumor;
import et.covid19.rest.swagger.model.RequestSaveRumor;

@Mapper
public interface RumorReportMapper {

	RumorReportMapper INSTANCE = Mappers.getMapper(RumorReportMapper.class);
	
	@Mappings({
	    @Mapping(target = "status.enumCode", source = "status.id")
	})
	RumorReport modelToEntity(ModelRumor model);

	@Mappings({
        @Mapping(target = "status.id", source = "status.enumCode"),
        @Mapping(target = "status.value", source = "status.enumLabel")
    })
	ModelRumor entityToModel(RumorReport entity);
	
	@Mappings({
	    @Mapping(target = "status.enumCode", source = "status.id")
    })
	RumorReport modelToEntity(RequestSaveRumor model);
}
