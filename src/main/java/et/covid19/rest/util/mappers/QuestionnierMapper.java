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
	
	
	@Mappings({
		@Mapping(target = "createdDate", source="insertDate"),
		@Mapping(target = "category", source="category.id")
	})
	Questionier modelQuestionierToEntityMapper(ModelQuestionnier q);
	
	@Mappings({
		@Mapping(target = "category.id", source="id"),
		@Mapping(target = "category.value", source="question")
	})
	ModelQuestionnier entityToModelQuestionnierMapper(Questionier q);
	
	
	@Mappings({
		@Mapping(target = "id", ignore=true),
		@Mapping(target = "createdDate", source="insertDate"),
		@Mapping(target = "category", source="category.id")
	})
	Questionier modelQuestionierToEntityMapper(RequestSaveQuestionnier q); //similar fields with ModelQuestionnier
}
