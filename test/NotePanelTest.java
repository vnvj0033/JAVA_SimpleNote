import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotePanelTest {

    @Test
    void testCreate() {
        NotePanel panel = new NotePanel();
        panel.setVisible(true);

        assertEquals(panel.getName(), NotePanel.NAME);

        JButton button = panel.getAddButton();
        assertEquals(button.getText(), "Add");
        assertTrue(button.isVisible());

        JLabel departmentLabel = panel.getNoteTextLabel();
        assertEquals(departmentLabel.getText(), "text");
        assertTrue(departmentLabel.isVisible());

        JLabel searchLabel = panel.getSearchLabel();
        assertEquals(searchLabel.getText(), "Search");
        assertTrue(searchLabel.isVisible());
    }
}