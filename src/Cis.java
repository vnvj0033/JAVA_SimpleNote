import javax.swing.*;

public class Cis {

    public static final String TITLE = "course info system";
    public static final int WIDTH = 200;
    public static final int HEIGHT = 400;

    private JFrame frame = new JFrame(TITLE);

    public static void main(String[] args) {
        new Cis().show();
    }

    Cis() {
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void show() {
        frame.setVisible(true);
    }
}
