package et.covid19.rest.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import et.covid19.rest.dal.model.PuiFollowUp;
import et.covid19.rest.swagger.model.ModelPuiFollowUp;

@Mapper
public interface PuiCaseFolowUpMapper {

	PuiCaseFolowUpMapper INSTANCE = Mappers.getMapper(PuiCaseFolowUpMapper.class);

	// ignore auto_generated values
	@Mappings({ 
		@Mapping(target = "id", ignore = true),
		@Mapping(target = "questionier.id", source = "QId"),
		@Mapping(target = "optionSelected", source = "selectedOption"),
		@Mapping(target = "createdDate", source = "insertDate")
		})
	PuiFollowUp modelFollowupToEntityMapper(ModelPuiFollowUp in);

	@Mappings({ 
		@Mapping(target ="selectedOption" , source = "optionSelected"),
		@Mapping(target = "insertDate", source = "createdDate")
		})
	ModelPuiFollowUp entityToModelFollowupMapper(PuiFollowUp in);
}
