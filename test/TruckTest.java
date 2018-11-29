import Simulation.Vehicles.Cars.Trucks.*;
import Simulation.Vehicles.Cars.Trucks.Flak.Bed;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {

    @Test
    void getSpeedFactor() {
        Truck t = new Scania(3, 2, Color.black,  3);
        assertEquals(0.03, t.getSpeedFactor());
    }

    @Test
    void testMove() {
        Truck t = new MANG90(100, 0, Color.black,2);
        t.startEngine();
        t.move();
        assertEquals(249.9, t.getY());
    }

    @Test
    void getBed() {
        Truck t = new MANG90(100, 0, Color.black,2);
        Bed b = new Bed(t);

        t.setBed(b);
        assertEquals(b, t.getBed());
    }

    @Test
    void setBed() {
        Truck t = new MANG90(100, 0, Color.black,2);
        Bed b = new Bed(t);

        t.setBed(b);
        assertEquals(b, t.getBed());
    }
}