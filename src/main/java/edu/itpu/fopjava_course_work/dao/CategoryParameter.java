package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.entity.Medication;
import java.security.InvalidParameterException;
import java.util.List;

public record CategoryParameter(String category) implements Parameter<Medication> {
    public CategoryParameter{
        if( category == null || category.isBlank()){
            throw new InvalidParameterException("Category can't be empty");
        }
    }
    @Override
    public boolean test(Medication medication) {
        List<String> testCategories = medication.getCategories();
        if (testCategories.contains(category))
            return true;
        else
            return false;
    }
}
