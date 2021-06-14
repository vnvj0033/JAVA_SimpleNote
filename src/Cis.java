import javax.swing.*;

public class Cis {

    public static final String TITLE = "course info system";
    public static final int WIDTH = 200;
    public static final int HEIGHT = 400;

    private JFrame frame = new JFrame(TITLE);

    Cis() {
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public JFrame getFrame() {
        return frame;
    }
}
