package edu.itpu.fopjava_course_work.service;

import edu.itpu.fopjava_course_work.view.Observer;

import java.util.Collection;

public interface ObserverService {
    MedicationService registerObserver(Observer observer);
    void notifyObservers(Collection updatedCollection);
}
