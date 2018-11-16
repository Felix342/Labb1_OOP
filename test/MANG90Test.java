import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;

class MANG90Test {
    @Test
    void testGetSpeedFactor() {
        MANG90 m = new MANG90(2, 120, Color.BLUE, "MANG9O");
        assertEquals(0.9, m.getSpeedFactor());
    }
    @Test
    void testLowerLoad() {
        MANG90 m = new MANG90(2, 120, Color.BLUE, "MANG9O");
        m.lowerLoad();
        assertEquals(0, m.getDegrees());
    }
    @Test
    void testRaiseLoad() {
        MANG90 m = new MANG90(2, 120, Color.BLUE, "MANG9O");
        m.raiseLoad();
        assertEquals(70, m.getDegrees());
    }
    @Test
    void testMove() {
        MANG90 m = new MANG90(2, 120, Color.BLUE, "MANG9O");
        m.move();
        assertEquals(249, m.getY());
    }
    @Test
    void testGetDegrees() {
        MANG90 m = new MANG90(2, 120, Color.BLUE, "MANG9O");
        m.getDegrees();
        assertEquals(0, m.getDegrees());
    }
}
