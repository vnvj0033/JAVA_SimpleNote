import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TodoTableModel extends AbstractTableModel {
    List<Todo> todos = new ArrayList<>();

    public void add(Todo todo) {
        todos.add(todo);
        fireTableRowsInserted(todos.size() - 1, todos.size());
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public Todo getTodo(int index) {
        return todos.get(index);
    }

    public int getSize() {
        return getRowCount();
    }

    public String getText(int index) {
        return todos.get(index).getText();
    }

    @Override
    public int getRowCount() {
        return todos.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return todos.get(rowIndex).getText();
    }
}
