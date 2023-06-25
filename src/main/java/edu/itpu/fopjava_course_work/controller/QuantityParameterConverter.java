package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.dao.Parameter;
import edu.itpu.fopjava_course_work.dao.QuantityParameter;
import edu.itpu.fopjava_course_work.dao.Range;
import edu.itpu.fopjava_course_work.entity.Medication;

public class QuantityParameterConverter extends AbstractParameterConverter<Medication> {
    public QuantityParameterConverter() {
        super("QUANTITY");
    }

    @Override
    protected Parameter<Medication> internalConvert(String request) {
        String[] values = request.split(",");
        int[] numbers = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Integer.parseInt(values[i].trim());
        }//end of for

        Range<Integer> range = new Range<>(numbers[0], numbers[1]);
        return new QuantityParameter(range);
    }//end of internalConvert
}

