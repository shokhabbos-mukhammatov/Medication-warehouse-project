package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.entity.Medication;
import java.security.InvalidParameterException;

public record NameParameter(String name) implements Parameter<Medication> {
public NameParameter{
    if( name == null || name.isBlank()){
        throw new InvalidParameterException("Name can't be empty");
    }
}
    @Override
    public boolean test(Medication medication) {
        return name.equals(medication.getName());
    }
}
