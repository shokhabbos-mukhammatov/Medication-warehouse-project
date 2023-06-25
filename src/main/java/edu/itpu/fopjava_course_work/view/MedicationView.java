package edu.itpu.fopjava_course_work.view;

import edu.itpu.fopjava_course_work.service.MedicationService;

import java.util.Collection;

public class MedicationView implements Observer{
    private MedicationService medicationService;
    public MedicationView(MedicationService medicationService){
            this.medicationService = medicationService;
            this.medicationService.registerObserver(this);
    }

    public void update(Collection updatedCollection){
        if(updatedCollection!=null && !updatedCollection.isEmpty())
        updatedCollection.forEach(System.out::println);
        else {
            System.out.println("Nothing to display");
        }
    }
}
