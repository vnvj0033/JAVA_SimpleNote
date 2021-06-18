import javax.swing.*;
import java.awt.event.KeyEvent;

public class KeyRelease {
    private JTextField field;
    private JTable table;
    private CourseTableModel model;
    private CourseTableModel newModel;

    public void releas() {
        newModel = new CourseTableModel();
        if (field.getText().length() == 0) {
            table.setModel(model);
            return;
        }

        for (int i = 0; i < model.getRowCount(); i++)
            if (model.getCourse(i).getText().contains(field.getText()))
                newModel.add(model.getCourse(i));

        table.setModel(newModel);
    }

    public void setSearchFiled(JTextField field) {
        this.field = field;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public void setModel(CourseTableModel model) {
        this.model = model;
    }
}
