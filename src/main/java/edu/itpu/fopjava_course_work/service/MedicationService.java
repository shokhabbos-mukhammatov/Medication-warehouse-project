package edu.itpu.fopjava_course_work.service;

import edu.itpu.fopjava_course_work.dao.SearchCriteria;
import edu.itpu.fopjava_course_work.entity.Medication;

import java.util.Collection;

public interface MedicationService <A extends Medication> extends ObserverService {
     Collection<A> find(SearchCriteria<A> criteria, boolean expDatecheck);
     Collection<A> retrieveAllMedications();

}
