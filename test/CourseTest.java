import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {

    @Test
    void testCreate() {
        Course course = new Course();

        course.setText("TDD");

        assertEquals(course.getText(), "TDD");
    }
}
