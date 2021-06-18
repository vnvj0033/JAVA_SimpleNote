import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CisTest {
    Cis cis;
    JFrame frame;

    @BeforeEach
    void setUp() {
        cis = new Cis();
        frame = cis.getFrame();
    }

    @Test
    void testCreate() {
        assertEquals(frame.getTitle(), Cis.TITLE);
        assertEquals(frame.getDefaultCloseOperation(), JFrame.DISPOSE_ON_CLOSE);
        assertEquals(frame.getWidth(), Cis.WIDTH);
        assertEquals(frame.getHeight(), Cis.HEIGHT);
    }

    @Test
    void testShow() {
        cis.show();
        frame.setVisible(true);

        assertTrue(frame.isVisible());
    }
}
