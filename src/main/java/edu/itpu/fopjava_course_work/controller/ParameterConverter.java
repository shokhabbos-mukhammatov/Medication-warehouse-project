package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.dao.Parameter;
import edu.itpu.fopjava_course_work.entity.Medication;

public interface ParameterConverter<A extends Medication> {
    Parameter<A> convert(String request) throws ParameterConversionException;
}