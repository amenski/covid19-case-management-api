package et.covid19.rest.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import et.covid19.rest.dal.model.Questionier;
import et.covid19.rest.swagger.model.ModelQuestionnaire;
import et.covid19.rest.swagger.model.RequestSaveQuestionnaire;

@Mapper
public interface QuestionnaireMapper {

	QuestionnaireMapper INSTANCE = Mappers.getMapper(QuestionnaireMapper.class ); 
	
	
	@Mappings({
		@Mapping(target = "createdDate", source="insertDate"),
		@Mapping(target = "category.enumCode", source="category.id")
	})
	Questionier modelQuestionnaireToEntityMapper(ModelQuestionnaire q);
	
	@Mappings({
		@Mapping(target = "category.id", source="category.enumCode"),
		@Mapping(target = "category.value", source="category.enumLabel"),
	})
	ModelQuestionnaire entityToModelQuestionnaireMapper(Questionier q);
	
	
	@Mappings({
		@Mapping(target = "id", ignore=true),
		@Mapping(target = "createdDate", source="insertDate"),
		@Mapping(target = "category.enumCode", source="category.id")
	})
	Questionier modelQuestionnaireToEntityMapper(RequestSaveQuestionnaire q); //similar fields with ModelQuestionnier
}
