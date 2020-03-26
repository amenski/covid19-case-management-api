package et.covid19.rest.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import et.covid19.rest.dal.model.Questionier;
import et.covid19.rest.swagger.model.ModelQuestionnier;
import et.covid19.rest.swagger.model.RequestSaveQuestionnier;

@Mapper
public interface QuestionnierMapper {

	QuestionnierMapper INSTANCE = Mappers.getMapper(QuestionnierMapper.class ); 
	
	//ignore auto_generated values
	@Mappings({
		@Mapping(target = "id", ignore=true),
		@Mapping(target = "createdDate", source="insertDate")
	})
	Questionier modelQuestionierToEntityMapper(ModelQuestionnier q);
	
	ModelQuestionnier entityToModelQuestionnierMapper(Questionier q);
	
	Questionier modelQuestionierToEntityMapper(RequestSaveQuestionnier q); //similar fields with ModelQuestionnier
}
