import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CisTest {

    @Test
    void testCreate() {
        Cis cis = new Cis();
        JFrame frame = cis.getFrame();

        assertEquals(frame.getTitle(), Cis.TITLE);

        assertEquals(frame.getWidth(), Cis.WIDTH);
        assertEquals(frame.getHeight(), Cis.HEIGHT);
        assertEquals(frame.getDefaultCloseOperation(), JFrame.DISPOSE_ON_CLOSE);
    }
}
