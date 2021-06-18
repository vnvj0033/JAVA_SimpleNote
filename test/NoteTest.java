import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoteTest {

    @Test
    void testCreate() {
        String departmentName = "SimpleText^^";
        Note note = new Note();
        Note note1 = new Note(departmentName);

        note.setText(departmentName);

        assertEquals(note.getText(), departmentName);
        assertEquals(note1.getText(), departmentName);
    }
}
