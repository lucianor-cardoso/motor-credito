package com.financeiro.motor_credito.application.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Conversor de Boolean -> String -> Boolean
 *
 * @author Luciano R. Cardoso
 * @since 2026-03-31
 */
@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean atributo) {
        return (atributo != null && atributo) ? "S" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String info) {
        return "S".equals(info);
    }
}
