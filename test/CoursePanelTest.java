import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoursePanelTest {

    @Test
    void testCreate() {
        CoursePanel panel = new CoursePanel();

        assertEquals(panel.getName(), CoursePanel.NAME);
    }


    @Test
    void testTable() {
        CoursePanel panel = new CoursePanel();

        JTable table = (JTable)Util.getComponent(panel, CoursePanel.TABLE_NAME);

        assertEquals(table.getName(), CoursePanel.TABLE_NAME);
    }
}
