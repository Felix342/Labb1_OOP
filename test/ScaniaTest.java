import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    @Test
    void getDegrees() {
        Scania c = new Scania(2, 200, Color.CYAN, "Timya R620");
        assertEquals(0, c.getDegrees());
    }

    @Test
    void raiseLoad() {
        Scania c = new Scania(2, 200, Color.CYAN, "Timya R620");
        c.stopEngine();
        c.raiseLoad();
        assertEquals(1,  c.getDegrees());
    }

    @Test
    void lowerLoad() {
        Scania c = new Scania(2, 200, Color.CYAN, "Timya R620");
        c.stopEngine();
        c.lowerLoad();
        assertEquals(0, c.getDegrees());
    }

    @Test
    void getSpeedFactor() {
        Scania c = new Scania(2, 200, Color.CYAN, "Timya R620");

        assertEquals(1.5, c.getSpeedFactor());
    }
}