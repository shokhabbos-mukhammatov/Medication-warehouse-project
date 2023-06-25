package edu.itpu.fopjava_course_work.service;

import edu.itpu.fopjava_course_work.dao.DAOFactory;
import edu.itpu.fopjava_course_work.dao.MedicationDAO;
import edu.itpu.fopjava_course_work.dao.SearchCriteria;
import edu.itpu.fopjava_course_work.entity.Medication;
import edu.itpu.fopjava_course_work.view.Observer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public final class ServiceFactory {

    private MedicationDAO medicationDao = DAOFactory.getInstance().getMedicationDAO(Medication.class);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
    private static String currentDatestr = dateFormat.format(new Date());
    private static Date currentDate;


    static {
        try {
            currentDate = dateFormat.parse(currentDatestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public ServiceFactory() {

    }
    public MedicationService getAMedicationeService() {
        return new MedicationService() {
            private List <Observer> observers = new ArrayList <> ();
            @Override
            public Collection find(SearchCriteria criteria, boolean ignoreExpiredDate) {
                Collection<Medication> medications = medicationDao.find(criteria);

                // Additional filtering
                List<Medication> validMedications = new ArrayList<>();
                for (Medication medication : medications) {
                    if (ignoreExpiredDate == false) {
                        Date tempdate = null;
                        try {
                            tempdate = dateFormat.parse(medication.getExpirationDate());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        if (tempdate.compareTo(currentDate) <= 0)
                            validMedications.add(medication);
                    } else {
                        validMedications.add(medication);
                    }

                }
                notifyObservers(validMedications);
                return validMedications;
            }

            @Override
            public Collection retrieveAllMedications() {
                Collection<Medication> tempCollection = medicationDao.retriveAllMedications();
                notifyObservers(tempCollection);
                return tempCollection;
            }
            public MedicationService registerObserver(Observer observer) {
                observers.add(observer);
                return this;
            }
            public void notifyObservers(Collection updatedCollection) {
                for (Observer observer: observers) {
                    observer.update(updatedCollection);
                }
            }
        };
    }

}