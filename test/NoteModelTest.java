import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoModelTest {
    @Test
    void testAddCourse() {
        TodoTableModel model = new TodoTableModel();
        Todo todo = new Todo("TDD");

        model.add(todo);

        assertEquals(model.getRowCount(), 1);
        assertEquals(model.getTodo(0), todo);

        Todo todo1 = new Todo("TDD2");
        model.add(todo1);

        assertEquals(model.getRowCount(), 2);
        assertEquals(model.getTodo(1), todo1);
    }
}
