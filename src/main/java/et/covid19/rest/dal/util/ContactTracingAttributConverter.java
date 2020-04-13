package et.covid19.rest.dal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import et.covid19.rest.dal.model.ContactTracing;


@Converter
public class ContactTracingAttributConverter implements AttributeConverter<List<ContactTracing>, String> {

	private static final String SEPARATOR = "#";
	
	@Override
	public String convertToDatabaseColumn(List<ContactTracing> attribute) {
		StringBuilder sb = new StringBuilder();
		attribute.forEach(val -> sb.append(val.toString()).append(SEPARATOR));
		return sb.toString();
	}

	@Override
	public List<ContactTracing> convertToEntityAttribute(String dbData) {
		List<ContactTracing> list = new ArrayList<>();
		for(String single : Arrays.asList(dbData.split(SEPARATOR))) {
			ContactTracing ct = new ContactTracing();
			ct.setParentCaseCode(single);
			list.add(ct);
		}
//		return Arrays.asList(dbData.split(SEPARATOR));
		return list;
	}

}
