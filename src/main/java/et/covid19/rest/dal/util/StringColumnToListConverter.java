package et.covid19.rest.dal.util;

import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

import et.covid19.rest.util.EthConstants;

@Convert
public class StringColumnToListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        StringBuilder sb = new StringBuilder();
        attribute.stream().forEach(val -> sb.append(val).append(EthConstants.ATTRIBUTE_SEPARATOR));
        sb.setLength(sb.length() - 1);
        return null;
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return Arrays.asList(dbData.split(EthConstants.ATTRIBUTE_SEPARATOR));
    }

}
