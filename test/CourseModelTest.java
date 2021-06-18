import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseModelTest {
    @Test
    void testAddCourse() {
        CourseTableModel model = new CourseTableModel();
        Course course = new Course("TDD");

        model.add(course);

        assertEquals(model.getRowCount(), 1);
        assertEquals(model.getCourse(0), course);

        Course course1 = new Course("TDD2");
        model.add(course1);

        assertEquals(model.getRowCount(), 2);
        assertEquals(model.getCourse(1), course1);
    }
}
