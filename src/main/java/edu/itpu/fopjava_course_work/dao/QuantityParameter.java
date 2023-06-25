package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.entity.Medication;

import java.security.InvalidParameterException;


public record QuantityParameter(Range<Integer> range) implements Parameter<Medication> {
    public QuantityParameter {
        if (range.from() < 0) {
            throw new InvalidParameterException("Quantity can't be less than 0, but was " +
                    range.from());
        }
    }
    @Override
    public boolean test(Medication medication) {
        return range.isIn(medication.getQuantity());
    }
}
