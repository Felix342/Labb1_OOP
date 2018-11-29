import Simulation.Vehicles.Cars.Car;
import Simulation.Vehicles.Cars.Trucks.Scania;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    @Test
    void getDegrees() {
        Scania c = new Scania(2, 200, Color.CYAN,  2);
        assertEquals(0, c.getDegrees());
    }

    @Test
    void raiseLoad() {
        Scania c = new Scania(2, 200, Color.CYAN,  2);
        c.stopEngine();
        c.raiseLoad();
        assertEquals(1,  c.getDegrees());
    }

    @Test
    void lowerLoad() {
        Scania c = new Scania(2, 200, Color.CYAN,  2);
        c.stopEngine();
        c.lowerLoad();
        assertEquals(0, c.getDegrees());
    }

    @Test
    void getSpeedFactor() {
    Scania c = new Scania(2, 200, Color.CYAN,  2);

        assertEquals(0.02, c.getSpeedFactor());
    }

    @Test
    void testMove() {
        Car c= new Scania(100, 0, Color.black,2);
        c.startEngine();
        c.move();
        assertEquals(249.9, c.getY());
    }
}