package et.covid19.rest.dal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import et.covid19.rest.dal.model.ContactTracing;
import et.covid19.rest.util.EthConstants;


@Converter
public class ContactTracingAttributConverter implements AttributeConverter<List<ContactTracing>, String> {

	@Override
	public String convertToDatabaseColumn(List<ContactTracing> attribute) {
		StringBuilder sb = new StringBuilder();
		attribute.forEach(val -> sb.append(val.toString()).append(EthConstants.ATTRIBUTE_SEPARATOR));
		sb.setLength(sb.length() -1); //remove the last SEPARATOR char
		return sb.toString();
	}

	@Override
	public List<ContactTracing> convertToEntityAttribute(String dbData) {
		List<ContactTracing> list = new ArrayList<>();
		for(String single : Arrays.asList(dbData.split(EthConstants.ATTRIBUTE_SEPARATOR))) {
			ContactTracing ct = new ContactTracing();
			ct.setParentCaseCode(single);
			list.add(ct);
		}
		return list;
	}

}
