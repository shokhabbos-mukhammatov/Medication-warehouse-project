package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.entity.Medication;

import java.util.HashMap;
import java.util.Map;

public enum RawConverters {
    ID(new IdParameterConverter()),
    NAME(new NameParameterConverter()),
    CATEGORY(new CategoryParameterConverter()),
    PRICE(new PriceParameterConverter()),
    QUANTITY(new QuantityParameterConverter());

    private final ParameterConverter converter;

    RawConverters(ParameterConverter converter) {
        this.converter = converter;
    }

    @SuppressWarnings("unchecked")
    public <A extends Medication> ParameterConverter<A> generic() {
        return (ParameterConverter<A>) converter;
    }

    public static Map<String, ParameterConverter<Medication>> getConvertersMap() {
        Map<String, ParameterConverter<Medication>> convertersMap = new HashMap<>();
        for (RawConverters rawConverter : values()) {
            convertersMap.put(rawConverter.name(), rawConverter.generic());
        }//end of for
        return convertersMap;
    }//end of getConvertersMap
}
