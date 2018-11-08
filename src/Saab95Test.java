import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {
    Saab95 saab = new Saab95();
    @Test
    void getSpeedFactor() {
        assertEquals(1.25, saab.getSpeedFactor());
    }
}