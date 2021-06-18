import javax.swing.*;

public class Cis {
    static final String TITLE = "course info system";
    static final int WIDTH = 300;
    static final int HEIGHT = 400;

    private JFrame frame = new JFrame(TITLE);

    public static void main(String[] args) {
        new Cis().show();
    }

    Cis() {
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void show() {
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame
    }
}
