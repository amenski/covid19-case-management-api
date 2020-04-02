package et.covid19.rest.services.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import et.covid19.rest.annotations.EthLoggable;
import et.covid19.rest.dal.model.ConstantEnum;
import et.covid19.rest.services.IAttributeService;
import et.covid19.rest.swagger.model.ModelAttribute;
import et.covid19.rest.swagger.model.ModelAttributeList;
import et.covid19.rest.util.exception.EthException;
import et.covid19.rest.util.exception.EthExceptionEnums;
import et.covid19.rest.util.mappers.AttributesMapper;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AttributeServiceImpl extends AbstractService implements IAttributeService {

	@Override
	@EthLoggable
	public ModelAttributeList getAttributeList() throws EthException {
		try {
			List<ConstantEnum> attributeList = constantsEnumRepository.findAll();
			if(attributeList.isEmpty())
				throw EthExceptionEnums.CONSTANT_NOT_FOUND.get();
			
			ModelAttributeList modelAttrList = new ModelAttributeList();
			attributeList.stream().forEach(attr -> {
				if(!attr.getDisabled()) {
					ModelAttribute model = AttributesMapper.INSTANCE.entityToModelMapper(attr);
					modelAttrList.addAttributesItem(model);
				}
			});
			return modelAttrList;
		} catch (Exception ex) {
			throw ex;
		}
	}

}
