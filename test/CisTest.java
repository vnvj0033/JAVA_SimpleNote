import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CisTest {

    @Test
    void testCreate() {
        Cis cis = new Cis();

        assertEquals(cis.getTitle(), Cis.TITLE);

        assertEquals(frame.getWidth(), Cis.WIDTH);
        assertEquals(frame.getHeight(), Cis.HEIGHT);
    }

}
