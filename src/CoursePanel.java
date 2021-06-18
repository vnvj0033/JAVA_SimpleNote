import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

import static java.awt.GridBagConstraints.*;
import static java.awt.GridBagConstraints.HORIZONTAL;

public class CoursePanel extends JPanel {
    public static final String NAME = "course panel";

    private CourseTableModel tableModel = new CourseTableModel();

    private JTable table = new JTable(tableModel);
    private JButton addButton = new JButton("Add");
    private JTextField departmentTextField = new JTextField();
    private JTextField searchField = new JTextField();
    private JLabel departmentLabel = new JLabel("Department");
    private JLabel searchLabel = new JLabel("Search");


    CoursePanel() {
        setName(NAME);
        createLayout();
    }

    private void createLayout() {
        setLayout(new BorderLayout());

        final int pad = 6;
        Border emptyBorder = BorderFactory.createEmptyBorder(pad, pad, pad, pad);
        Border bevelBorder = BorderFactory.createBevelBorder(BevelBorder.RAISED);
        Border titleBorder = BorderFactory.createTitledBorder(bevelBorder, "Courses");
        setBorder(BorderFactory.createCompoundBorder(emptyBorder, titleBorder));

        add(createTable(), BorderLayout.CENTER);
        add(createBottom(), BorderLayout.SOUTH);
    }

    private JScrollPane createTable() {
        table.setShowGrid(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane coursesScroll = new JScrollPane(table);
        coursesScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        return coursesScroll;
    }

    private JPanel createBottom() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel field = createField();

        searchLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createRigidArea(new Dimension(0, 6)));
        panel.add(addButton);
        panel.add(Box.createRigidArea(new Dimension(0, 6)));
        panel.add(field);
        panel.add(Box.createRigidArea(new Dimension(0, 8)));
        panel.add(searchLabel);
        panel.add(searchField);

        panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        return panel;
    }

    private JPanel createField() {
        GridBagLayout layout = new GridBagLayout();

        JPanel panel = new JPanel(layout);

        departmentTextField.setColumns(20);

        Insets insets = new Insets(3, 3, 3, 3);

        layout.setConstraints(departmentLabel, new GridBagConstraints(
                0, 0,
                1, 1,
                40, 1,
                LINE_END, NONE,
                insets,
                0, 0));
        layout.setConstraints(departmentTextField, new GridBagConstraints(
                1, 0,
                2, 1,
                60, 1,
                CENTER, HORIZONTAL,
                insets,
                0, 0));

        panel.add(departmentLabel);
        panel.add(departmentTextField);

        return panel;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public CourseTableModel getTableModel() {
        return tableModel;
    }

    public JTextField getDepartmentTextField() {
        return departmentTextField;
    }

    public JTextField getSearchTextField() {return searchField;}

    public JTable getTable() {
        return table;
    }

    public JLabel getDepartmentLabel() {
        return departmentLabel;
    }

    public JLabel getSearchLabel() {
        return searchLabel;
    }
}