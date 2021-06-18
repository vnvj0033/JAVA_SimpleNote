import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Cis {
    static final String TITLE = "course info system";
    static final int WIDTH = 300;
    static final int HEIGHT = 400;

    private JFrame frame = new JFrame(TITLE);

    private CoursePanel panel = new CoursePanel();

    public static void main(String[] args) {
        new Cis().show();
    }

    Cis() {
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        addButtonClickListener();
    }

    public void show() {
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public CoursePanel getPanel() {
        return panel;
    }

    private void addButtonClickListener() {
        JButton addButton = panel.getAddButton();
        JTextField textField = panel.getDepartmentTextField();
        CourseTableModel model = panel.getTableModel();
        JTable table = panel.getTable();

        addButton.addActionListener(e -> {

            if (textField.getText().length() == 0)
                return;

            panel.getSearchTextField().setText(null);
            model.add(new Course(textField.getText()));
            table.setModel(model);
            textField.setText(null);
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10)
                    addButton.doClick();
            }
        });
    }
}
