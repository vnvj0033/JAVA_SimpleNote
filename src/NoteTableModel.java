import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class NoteTableModel extends AbstractTableModel {
    List<Note> notes = new ArrayList<>();

    public void add(Note note) {
        notes.add(note);
        fireTableRowsInserted(notes.size() - 1, notes.size());
    }

    public List<Note> getTodos() {
        return notes;
    }

    public Note getTodo(int index) {
        return notes.get(index);
    }

    public int getSize() {
        return getRowCount();
    }

    public String getText(int index) {
        return notes.get(index).getText();
    }

    @Override
    public int getRowCount() {
        return notes.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return notes.get(rowIndex).getText();
    }
}
