import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {

    @Test
    void testCreate() {
        Course course = new Course("Tdd");

        assertEquals(course.getDepartment(), "Tdd");
    }
}
