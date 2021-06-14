import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoursePanelTest {

    @Test
    void testCreate() {
        CoursePanel panel = new CoursePanel();

        assertEquals(panel.getName(), CoursePanel.NAME);
    }
}
