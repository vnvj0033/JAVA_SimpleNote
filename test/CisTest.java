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
    /*
    given:
    123이 저장되어 있다면 => courses.add("123")

    when:
    1을 넣고 search를 하면 => field에 1을 넣는다. field.setText(1)
    search() => field 값을 확인해야지. 그걸 가지고 찾으면 되는거 아냐...

    then:
    searchResult...
    123이 나온다.
    검색 결과가 하나다.
     */
    @Test
    void testSearchListener() {
        CoursePanel panel = cis.getPanel();

        JButton button = panel.getAddButton();
        JTextField field = panel.getDepartmentTextField();
        JTable table = panel.getTable();
        CourseTableModel model = panel.getTableModel();

        field.setText("ATDD");
        button.doClick();

        JTextField searchField = panel.getDepartmentTextField();

        KeyRelease keyRelease = new KeyRelease();
        keyRelease.setSearchFiled(searchField);
        keyRelease.setTable(table);
        keyRelease.setModel(model);

        searchField.setText("1");

        keyRelease.releas();

        assertEquals(table.getModel().getRowCount(), 0);

        searchField.setText("A");

        keyRelease.releas();
        assertEquals(table.getModel().getRowCount(), 1);

        assertEquals(((CourseTableModel) table.getModel()).getCourse(0).getText(), "ATDD");
    }
}
