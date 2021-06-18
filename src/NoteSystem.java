import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NoteSystem {
    static final String TITLE = "simple note";
    static final int WIDTH = 300;
    static final int HEIGHT = 400;

    private JFrame frame = new JFrame(TITLE);

    private NotePanel panel = new NotePanel();


    public static void main(String[] args) {
        new NoteSystem().show();
    }

    NoteSystem() {
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        addButtonClickListener();
        addSearchListener();
    }

    public void show() {
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public NotePanel getPanel() {
        return panel;
    }

    private void addButtonClickListener() {
        JButton addButton = panel.getAddButton();

        JTextField textField = panel.getNoteTextField();
        AddEvent addEvent = new AddEvent(panel);

        addButton.addActionListener(e -> addEvent.clickEvent());

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                addEvent.enterEvent(e);
            }
        });
    }
    private void addSearchListener() {
        JTextField field = panel.getSearchTextField();
        KeyRelease key = new KeyRelease();

        key.setSearchFiled(field);
        key.setTable(panel.getTable());
        key.setModel(panel.getTableModel());

        field.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                key.event();
            }
        });
    }
}
