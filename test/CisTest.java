import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.InputEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CisTest {
    Cis cis;
    JFrame frame;

    @BeforeEach
    void setUp() {
        cis = new Cis();
        frame = cis.getFrame();
    }

    @Test
    void testCreate() {
        assertEquals(frame.getTitle(), Cis.TITLE);
        assertEquals(frame.getDefaultCloseOperation(), JFrame.DISPOSE_ON_CLOSE);
        assertEquals(frame.getWidth(), Cis.WIDTH);
        assertEquals(frame.getHeight(), Cis.HEIGHT);
    }

    @Test
    void testShow() {
        cis.show();
        frame.setVisible(true);

        assertTrue(frame.isVisible());
    }

    Boolean wasClick;

    @Test
    void testButtonListener() {
        JButton button = new JButton();
        wasClick = false;
        button.addActionListener(e -> wasClick = true);
        button.doClick();

        assertTrue(wasClick);
    }

    @Test
    void testAddCourse() {
        CoursePanel panel = cis.getPanel();

        JButton button = panel.getAddButton();
        JTextField field = panel.getDepartmentTextField();
        CourseTableModel model = panel.getTableModel();

        field.setText("ATDD");
        button.doClick();

        assertEquals(model.getCourse(0).getText(), "ATDD");
        assertEquals(field.getText(), "");
    }

    @Test
    void testSearchListener() throws AWTException {
        Robot robot = new Robot();

        CoursePanel panel = cis.getPanel();

        JButton button = panel.getAddButton();
        JTextField field = panel.getDepartmentTextField();

        field.setText("ATDD");
        button.doClick();

        JTextField searchField = panel.getDepartmentTextField();

        Point point = searchField.getLocationOnScreen();
        robot.mouseMove(point.x, point.y);

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.keyPress('1');
        robot.keyRelease('1');

        assertEquals(panel.getTableModel().getRowCount(), 0);

        searchField.setText("");

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        robot.keyPress('A');
        robot.keyRelease('A');

        assertEquals(panel.getTableModel().getRowCount(), 1);
    }
}
