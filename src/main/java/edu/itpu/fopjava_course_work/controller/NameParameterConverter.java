package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.dao.NameParameter;
import edu.itpu.fopjava_course_work.dao.Parameter;
import edu.itpu.fopjava_course_work.entity.Medication;

public class NameParameterConverter extends AbstractParameterConverter<Medication> {
    public NameParameterConverter() {
        super("NAME");
    }

    @Override
    protected Parameter<Medication> internalConvert(String request) {
            return new NameParameter(request);
    }
}