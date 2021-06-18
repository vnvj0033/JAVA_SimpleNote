import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoPanelTest {

    @Test
    void testCreate() {
        CoursePanel panel = new CoursePanel();
        panel.setVisible(true);

        assertEquals(panel.getName(), CoursePanel.NAME);

        JButton button = panel.getAddButton();
        assertEquals(button.getText(), "Add");
        assertTrue(button.isVisible());

        JLabel departmentLabel = panel.getDepartmentLabel();
        assertEquals(departmentLabel.getText(), "Department");
        assertTrue(departmentLabel.isVisible());

        JLabel searchLabel = panel.getSearchLabel();
        assertEquals(searchLabel.getText(), "Search");
        assertTrue(searchLabel.isVisible());
    }
}