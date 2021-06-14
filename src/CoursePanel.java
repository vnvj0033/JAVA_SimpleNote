import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class CoursePanel extends JPanel {
    public static final String NAME = "coursePanelName";

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
    }
}
