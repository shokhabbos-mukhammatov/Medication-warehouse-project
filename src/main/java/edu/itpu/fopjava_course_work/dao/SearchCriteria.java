package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.entity.Medication;

public interface SearchCriteria<A extends Medication> {
    <P extends Parameter<A>> SearchCriteria<A> add( P parameter);
    boolean test(A medication);
}
