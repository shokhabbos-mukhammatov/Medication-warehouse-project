package edu.itpu.fopjava_course_work.dao;

import edu.itpu.fopjava_course_work.entity.Medication;

import java.util.ArrayList;
import java.util.List;

public class MedicationCriteria<A extends Medication> implements SearchCriteria<A>{
    public final List<Parameter<A>> parameters= new ArrayList<>();

    @Override
    public <F extends Parameter<A>> SearchCriteria<A> add( F parameter) {
        parameters.add( parameter);
        return this;
    }

    @Override
    public boolean test(A medication) {
        boolean result = false;
        if(medication != null)
        for(int i=0;i< parameters.size();i++){
        Parameter<A> param = parameters.get(i);
            if(param.test(medication)){
            result = true;
            }
            else {
                return false;
            }
        }
        return result ;
    }
}
