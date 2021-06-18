import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TotoSystemTest {
    TodoSystem todoSys;
    JFrame frame;
    KeyRelease keyRelease;
    JTable table;

    @BeforeEach
    void setUp() {
        todoSys = new TodoSystem();
        frame = todoSys.getFrame();
        keyRelease = new KeyRelease();
        table = todoSys.getPanel().getTable();
    }

    @Test
    void testCreate() {
        assertEquals(frame.getTitle(), TodoSystem.TITLE);
        assertEquals(frame.getDefaultCloseOperation(), JFrame.DISPOSE_ON_CLOSE);
        assertEquals(frame.getWidth(), TodoSystem.WIDTH);
        assertEquals(frame.getHeight(), TodoSystem.HEIGHT);
    }

    @Test
    void testShow() {
        todoSys.show();
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
        CoursePanel panel = todoSys.getPanel();

        JButton button = panel.getAddButton();
        JTextField field = panel.getDepartmentTextField();
        TodoTableModel model = panel.getTableModel();

        field.setText("ATDD");
        button.doClick();

        assertEquals(model.getTodo(0).getText(), "ATDD");
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
        CoursePanel panel = todoSys.getPanel();

        JButton button = panel.getAddButton();
        JTextField field = panel.getDepartmentTextField();
        TodoTableModel model = panel.getTableModel();
        JTextField searchField = panel.getDepartmentTextField();

        field.setText("ATDD");
        button.doClick();


        keyRelease.setSearchFiled(searchField);
        keyRelease.setTable(table);
        keyRelease.setModel(model);

        assertFiledInput(searchField, "1", 0);
        assertFiledInput(searchField, "A", 1);

        assertEquals(((TodoTableModel) table.getModel()).getTodo(0).getText(), "ATDD");
    }

    private void textInput(JTextField field, String text) {
        field.setText(text);
        keyRelease.releas();
    }

    private void assertFiledInput(JTextField field, String text, int size) {
        textInput(field, text);
        assertEquals(table.getModel().getRowCount(), size);
    }
}
