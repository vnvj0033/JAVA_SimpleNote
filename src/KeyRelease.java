import javax.swing.*;

public class KeyRelease {
    private JTextField field;
    private JTable table;
    private NoteTableModel model;
    private NoteTableModel newModel;

    public void event() {
        newModel = new NoteTableModel();
        if (field.getText().length() == 0) {
            table.setModel(model);
            return;
        }

        for (int i = 0; i < model.getRowCount(); i++)
            if (model.getTodo(i).getText().contains(field.getText()))
                newModel.add(model.getTodo(i));

        table.setModel(newModel);
    }

    public void setSearchFiled(JTextField field) {
        this.field = field;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public void setModel(NoteTableModel model) {
        this.model = model;
    }
}
