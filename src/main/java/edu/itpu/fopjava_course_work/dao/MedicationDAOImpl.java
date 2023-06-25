package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.entity.Medication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MedicationDAOImpl implements MedicationDAO<Medication>{

    private final CsvLineParser<Medication> parser = new CsvLineParserImpl();
    List<Medication> listOfRecords;
public MedicationDAOImpl(String path){
     listOfRecords = parser.parseCsv(path);
}

    @Override
    public Collection<Medication> find(SearchCriteria<Medication> criteria) {
        List<Medication> tempListOfRecords = new ArrayList<>();
        for(int i=0;i<listOfRecords.size();i++){
            if(criteria.test(listOfRecords.get(i))){
                tempListOfRecords.add((listOfRecords.get(i)));
            }
        }
        return tempListOfRecords;
    }

    @Override
    public Collection<Medication> retriveAllMedications() {
        return listOfRecords;
    }
}
