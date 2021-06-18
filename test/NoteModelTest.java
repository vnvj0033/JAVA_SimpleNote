import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoteModelTest {
    @Test
    void testAddCourse() {
        NoteTableModel model = new NoteTableModel();
        Note note = new Note("TDD");

        model.add(note);

        assertEquals(model.getRowCount(), 1);
        assertEquals(model.getTodo(0), note);

        Note note1 = new Note("TDD2");
        model.add(note1);

        assertEquals(model.getRowCount(), 2);
        assertEquals(model.getTodo(1), note1);
    }
}
