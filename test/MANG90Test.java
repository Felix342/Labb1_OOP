import Simulation.Vehicles.Cars.Car;
import Simulation.Vehicles.Cars.Trucks.MANG90;
import Simulation.Vehicles.Cars.Saab95;
import Simulation.Vehicles.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;

class MANG90Test {
    @Test
    void testGetSpeedFactor() {
        MANG90 m = new MANG90(100, 0, Color.black,2);
        assertEquals(1.0, m.getSpeedFactor());
    }
    @Test
    void testLowerLoad() {
        MANG90 m = new MANG90(100, 0, Color.black,2);
        m.lowerLoad();
        assertEquals(0, m.getDegrees());
    }
    @Test
    void testRaiseLoad() {
        MANG90 m = new MANG90(100, 0, Color.black,2);
        m.raiseLoad();
        assertEquals(70, m.getDegrees());
    }
    @Test
    void testMove() {
        MANG90 m = new MANG90(100, 0, Color.black,2);
        m.startEngine();
        m.move();
        assertEquals(249.9, m.getY());
    }

    @Test
    void load() {
        MANG90 m = new MANG90(100, 0, Color.black,2);
        Car c = new Saab95(1,0,Color.black,3);

        m.load(c);

        boolean test = m.getTrailer().getFirstCar().equals(c);
        assertEquals(true, test);


    }

    @Test
    void unLoad() {
        MANG90 m = new MANG90(100, 0, Color.black,2);
        Car c = new Saab95(1,0,Color.black,3);
        m.load(c);
        assertEquals(c, m.unLoad());
    }

    @Test
    void turnLeft() {
        MANG90 m = new MANG90(100, 0, Color.black,2);

        m.turnLeft();

        assertEquals(Vehicle.Direction.LEFT ,m.getDirection());
    }

    @Test
    void turnRight() {
        MANG90 m = new MANG90(100, 0, Color.black,2);
        m.turnRight();

        assertEquals(Vehicle.Direction.RIGHT ,m.getDirection());
    }
}
