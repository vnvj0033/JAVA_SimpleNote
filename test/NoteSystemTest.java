import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NoteSystemTest {
    NoteSystem todoSys;
    JFrame frame;
    KeyRelease keyRelease;
    JTable table;

    @BeforeEach
    void setUp() {
        todoSys = new NoteSystem();
        frame = todoSys.getFrame();
        keyRelease = new KeyRelease();
        table = todoSys.getPanel().getTable();
    }

    @Test
    void testCreate() {
        assertEquals(frame.getTitle(), NoteSystem.TITLE);
        assertEquals(frame.getDefaultCloseOperation(), JFrame.DISPOSE_ON_CLOSE);
        assertEquals(frame.getWidth(), NoteSystem.WIDTH);
        assertEquals(frame.getHeight(), NoteSystem.HEIGHT);
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
        NotePanel panel = todoSys.getPanel();

        JButton button = panel.getAddButton();
        JTextField field = panel.getNoteTextField();
        NoteTableModel model = panel.getTableModel();

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
        NotePanel panel = todoSys.getPanel();

        JButton button = panel.getAddButton();
        JTextField field = panel.getNoteTextField();
        NoteTableModel model = panel.getTableModel();
        JTextField searchField = panel.getNoteTextField();

        field.setText("ATDD");
        button.doClick();


        keyRelease.setSearchFiled(searchField);
        keyRelease.setTable(table);
        keyRelease.setModel(model);

        assertFiledInput(searchField, "1", 0);
        assertFiledInput(searchField, "A", 1);

        assertEquals(((NoteTableModel) table.getModel()).getTodo(0).getText(), "ATDD");
    }

    private void textInput(JTextField field, String text) {
        field.setText(text);
        keyRelease.event();
    }

    private void assertFiledInput(JTextField field, String text, int size) {
        textInput(field, text);
        assertEquals(table.getModel().getRowCount(), size);
    }
}
