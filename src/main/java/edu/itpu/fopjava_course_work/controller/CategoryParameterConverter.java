package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.dao.CategoryParameter;
import edu.itpu.fopjava_course_work.dao.Parameter;
import edu.itpu.fopjava_course_work.entity.Medication;

public class CategoryParameterConverter extends AbstractParameterConverter<Medication> {
 public CategoryParameterConverter() {
    super("CATEGORY");
 }

 @Override
 protected Parameter<Medication> internalConvert(String request) {
        return new CategoryParameter(request);
    }
}
