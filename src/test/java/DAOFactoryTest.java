import edu.itpu.fopjava_course_work.dao.DAOFactory;
import edu.itpu.fopjava_course_work.dao.MedicationDAO;
import edu.itpu.fopjava_course_work.entity.Medication;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DAOFactoryTest {

    @Test
    void shouldReturnNullWhenUnknownClassIsPassed() {
        class DummyClass extends Medication {}
        MedicationDAO<DummyClass> dao =
                DAOFactory.getInstance().getMedicationDAO(DummyClass.class);
        assertNull(dao);
    }

    @Test
    void shouldReturnMedicationDAO() {
        MedicationDAO<Medication> dao = DAOFactory.getInstance().getMedicationDAO(Medication.class);
        assertNotNull(dao);
        assertTrue(dao instanceof MedicationDAO<Medication>);
    }
}
