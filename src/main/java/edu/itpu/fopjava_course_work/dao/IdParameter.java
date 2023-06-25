package edu.itpu.fopjava_course_work.dao;
import edu.itpu.fopjava_course_work.entity.Medication;
import java.security.InvalidParameterException;

public record IdParameter(int id) implements Parameter<Medication>{
    public IdParameter {
        if (id <= 0) {
                throw new InvalidParameterException("ID can't be equal or less than 0, but was " +
                        id);
        }
    }

    @Override
    public boolean test(Medication medication) {
        return id == medication.getId();
    }
}
