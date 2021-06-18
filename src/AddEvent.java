import javax.swing.*;
import java.awt.event.KeyEvent;

public class AddEvent {
    private final JButton addButton;
    private final JTextField textField;
    private final NoteTableModel model;
    private final JTable table;
    private final JTextField searchField;

    AddEvent(NotePanel panel) {
        this.addButton = panel.getAddButton();
        this.textField = panel.getNoteTextField();
        this.model = panel.getTableModel();
        this.table = panel.getTable();
        this.searchField = panel.getSearchTextField();
    }
    public void enterEvent(KeyEvent e) {
        if (e.getKeyCode() == 10)
            addButton.doClick();

    }

    public void clickEvent() {
        if (textField.getText().length() == 0)
            return;

        searchField.setText(null);
        model.add(new Note(textField.getText()));
        table.setModel(model);
        textField.setText(null);
    }
}
