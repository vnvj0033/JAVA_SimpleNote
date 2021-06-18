import org.junit.jupiter.api.Test;

public class CourseModelTest {
    @Test
    void testAddCourse() {
        CourseTableModel model = new CourseTableModel();

        Course course = new Course("TDD");

        model.add(course);

        assertEquals(model.getRowCount(), 1);
        assertEquals(model.getCourse(0), course);
    }
}
