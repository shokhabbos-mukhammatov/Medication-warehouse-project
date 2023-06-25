package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.entity.Medication;

import java.util.Collection;

public interface MedicationDAO <A extends Medication>{
    Collection<A> find(SearchCriteria<A> criteria);
    Collection<A> retriveAllMedications();
}
