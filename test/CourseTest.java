import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {

    @Test
    void testCreate() {
        String departmentName = "TDD^^";
        Course course = new Course();
        Course course1 = new Course(departmentName);

        course.setText(departmentName);

        assertEquals(course.getText(), departmentName);
        assertEquals(course1.getText(), departmentName);
    }
}
