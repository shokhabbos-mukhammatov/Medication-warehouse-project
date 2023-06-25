package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.dao.Parameter;
import edu.itpu.fopjava_course_work.entity.Medication;

public abstract class AbstractParameterConverter<A extends Medication> implements ParameterConverter<A> {
 private final String parameterName;

 protected AbstractParameterConverter(String parameterName) {
        this.parameterName = parameterName;
    }

 @Override
 public Parameter<A> convert(String request) throws ParameterConversionException {
    try {
            return internalConvert(request);
        }
    catch (ParameterConversionException p) {
            throw new ParameterConversionException("Conversion failed", p);
        }
 }

 protected abstract Parameter<A> internalConvert(String request) throws ParameterConversionException;
}