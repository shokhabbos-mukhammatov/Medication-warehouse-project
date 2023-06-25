package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.entity.Medication;

public interface Parameter<A extends Medication> {
    boolean test(A medication);
}
