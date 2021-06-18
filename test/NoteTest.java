import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {

    @Test
    void testCreate() {
        String departmentName = "TDD^^";
        Todo todo = new Todo();
        Todo todo1 = new Todo(departmentName);

        todo.setText(departmentName);

        assertEquals(todo.getText(), departmentName);
        assertEquals(todo1.getText(), departmentName);
    }
}
