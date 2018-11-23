import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void getNrDoors() {

        Car c = new Saab95(3, 3, Color.black, "ds", 4);
        assertEquals(4, c.getNrDoors());

    }

    @Test
    void setNrDoors() {
        Car c = new Saab95(3, 3, Color.black, "ds", 4);
        c.setNrDoors(2);
        assertEquals(2, c.getNrDoors());
    }
}