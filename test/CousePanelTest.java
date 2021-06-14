import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CousePanelTest {

    @Test
    void testCreate() {
        CoursePanel panel = new CoursePanel();

        assertEquals(panel.getName(), CoursePanel.NAME);
    }
}
