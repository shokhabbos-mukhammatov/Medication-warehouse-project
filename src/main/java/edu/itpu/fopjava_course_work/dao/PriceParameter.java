package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.entity.Medication;

import java.security.InvalidParameterException;

public record PriceParameter(Range<Double> range) implements Parameter<Medication> {
    public PriceParameter {
        if (range.from() <= 0) {
            throw new InvalidParameterException("Price can't be equal or less than 0, but was " +
                    range.from());
        }
    }
    @Override
    public boolean test(Medication medication) {
        return range.isIn(medication.getPrice());
    }
}
