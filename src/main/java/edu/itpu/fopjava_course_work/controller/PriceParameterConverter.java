package edu.itpu.fopjava_course_work.controller;

import edu.itpu.fopjava_course_work.dao.Parameter;
import edu.itpu.fopjava_course_work.dao.PriceParameter;
import edu.itpu.fopjava_course_work.dao.Range;
import edu.itpu.fopjava_course_work.entity.Medication;

public class PriceParameterConverter extends AbstractParameterConverter<Medication> {
    public PriceParameterConverter() {
        super("PRICE");
    }

    @Override
    protected Parameter<Medication> internalConvert(String request) {
        String[] values = request.split(",");
        double[] numbers = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            numbers[i] = Double.parseDouble(values[i].trim());

        }//end of for
        Range<Double> range = new Range<>(numbers[0], numbers[1]);
        return new PriceParameter(range);
    }//end of internalConvert
}

