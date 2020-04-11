package et.covid19.rest.util.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import et.covid19.rest.dal.model.EthUser;
import et.covid19.rest.swagger.model.ModelUser;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	@Mappings({
		@Mapping(target = "username", source = "email")
	})
	EthUser modelToEntity(ModelUser model);
	
	@Mappings({
		@Mapping(target = "email", source = "username")
	})
	ModelUser entityToModel(EthUser entity);
}
