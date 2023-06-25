package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.dao.IdParameter;
import edu.itpu.fopjava_course_work.dao.Parameter;
import edu.itpu.fopjava_course_work.entity.Medication;

public class IdParameterConverter extends AbstractParameterConverter<Medication> {
    public IdParameterConverter() {
        super("ID");
    }

    @Override
    protected Parameter<Medication> internalConvert(String request) {
        return new IdParameter(Integer.parseInt(request));
    }
}