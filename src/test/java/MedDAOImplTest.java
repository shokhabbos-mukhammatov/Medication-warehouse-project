import edu.itpu.fopjava_course_work.dao.MedicationCriteria;
import edu.itpu.fopjava_course_work.dao.MedicationDAOImpl;
import edu.itpu.fopjava_course_work.dao.Parameter;
import edu.itpu.fopjava_course_work.entity.Medication;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MedDAOImplTest {
    interface ParameterExtTest<A extends Medication> extends Parameter<A> {
        static <A extends Medication> Parameter<A> any() {
            return appliance -> true;
        }

        static <A extends Medication> Parameter<A> none() {
            return appliance -> false;
        }
    }

    @Test
    void shouldFindAll() {
        // arrange
        MedicationDAOImpl dao = new MedicationDAOImpl("src\\main\\newtest.csv");
        Medication[] expected = new Medication[] {
                new Medication().setId(1).setName("analgin").setCategories(Arrays.asList("a", "b", "c")).
                        setPrice(10).setQuantity(1000).setDate("11-01-2023"),
                new Medication().setId(2).setName("teraflue").setCategories(Arrays.asList("b", "d" , "f")).
                        setPrice(20).setQuantity(300).setDate("12-01-2023"),
                new Medication().setId(3).setName("vitamin c").setCategories(Arrays.asList("c", "m")).
                        setPrice(50).setQuantity(14).setDate("10-02-2023"),
                new Medication().setId(4).setName("crufmol").setCategories(Arrays.asList("d", "a")).
                        setPrice(100).setQuantity(0).setDate("11-01-2023"),};
        System.out.println(expected[0]);


        // action
        Iterable<Medication> iterable = dao.find(
                new MedicationCriteria().add(ParameterExtTest.any()));

        // assert
        assertNotNull(iterable);
        Medication[] medications = toArray(iterable, Medication[]::new);
        assertArrayEquals(expected, medications);
    }

    @Test
    void shouldFindNone() {
        // arrange
        MedicationDAOImpl dao = new MedicationDAOImpl("src\\main\\newtest.csv");
        // action
        Iterable<Medication> iterable = dao.find(
                new MedicationCriteria().add(ParameterExtTest.none()));
        // assert
        assertNotNull(iterable);
        Medication[] medications = toArray(iterable, Medication[]::new);
        assertArrayEquals(new Medication[0], medications);
    }

    private <A extends Medication> A[] toArray(Iterable<A> iterable,
                                                 IntFunction<A[]> arrayGen) {
        List<A> list = new ArrayList<>();
        iterable.forEach(list::add);
        A[] arr = list.toArray(arrayGen);
        Arrays.sort(arr, Comparator.comparingDouble(Medication::getPrice));
        return arr;
    }
}
