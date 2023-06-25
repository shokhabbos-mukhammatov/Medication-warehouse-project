package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.entity.Medication;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    public static DAOFactory getInstance() {
        return instance;
    }

    @SuppressWarnings("unchecked")
    public <A extends Medication> MedicationDAO<A> getMedicationDAO(Class<A> medicationClass){
        if(Medication.class.equals(medicationClass))
        return (MedicationDAO<A>) new MedicationDAOImpl("src\\main\\newtest.csv");

        return null;
    }

}
