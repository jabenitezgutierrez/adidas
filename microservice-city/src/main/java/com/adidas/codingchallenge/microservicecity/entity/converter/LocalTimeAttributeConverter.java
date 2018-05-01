package com.adidas.codingchallenge.microservicecity.entity.converter;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converter to persist LocalTime with JPA
 * and Hibernate
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@Converter(autoApply = true)
public class LocalTimeAttributeConverter implements AttributeConverter<LocalTime, Time>{

    @Override
    public Time convertToDatabaseColumn(LocalTime localTime) {
        return (localTime == null ? null : Time.valueOf(localTime));
    }

    @SuppressWarnings("deprecation")
    @Override
    public LocalTime convertToEntityAttribute(Time time) {
        return (time == null ? null : LocalTime.of(time.getHours(), time.getMinutes()));
    }
}
