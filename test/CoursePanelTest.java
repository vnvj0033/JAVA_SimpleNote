import org.junit.jupiter.api.Test;

public class CoursePanelTest {

    @Test
    void testCreate() {
        CoursePanel panel = new CoursePanel();
        panel.setVisible(true);

        assertEquals(panel.getName(), CoursePanel.NAME);

        CourseTableModel model = panel.getTableModel();
        JTable table = panel.getTable();
        assertEquals(table.getModel(), model);

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