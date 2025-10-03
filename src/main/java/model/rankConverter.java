package model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = false)
public class rankConverter implements AttributeConverter<aikidoRank, Integer> {
    @Override
    public Integer convertToDatabaseColumn(aikidoRank attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public aikidoRank convertToEntityAttribute(Integer dbData) {
        return aikidoRank.fromValue(dbData);
    }
}
