package et.covid19.rest.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import et.covid19.rest.dal.model.ConstantEnum;
import et.covid19.rest.swagger.model.ModelAttribute;

@Mapper
public interface AttributesMapper {

	AttributesMapper INSTANCE = Mappers.getMapper(AttributesMapper.class);

	@Mappings({
		@Mapping(target="attName", source="enumName"),
		@Mapping(target="attType", source="enumType"),
		@Mapping(target="attCode", source="enumCode"),
		@Mapping(target="attLabel", source="enumLabel"),
		@Mapping(target="attDesc", source="enumDesc"),
	})
	ModelAttribute entityToModelMapper(ConstantEnum attr);

}
