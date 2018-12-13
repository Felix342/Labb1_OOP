import Simulation.Vehicles.CarFerry;
import Simulation.Vehicles.Cars.Car;
import Simulation.Vehicles.Cars.Saab95;
import Simulation.Vehicles.Vehicle;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarFerryTest {

    @Test
    void testLowerLoad() {
        CarFerry c = new CarFerry(100, 0, Color.black,"Thanos");
        c.lowerLoad();
        assertEquals(0, c.getDegrees());
    }
    @Test
    void testRaiseLoad() {
        CarFerry c = new CarFerry(100, 0, Color.black,"Thanos");
        c.raiseLoad();
        assertEquals(70, c.getDegrees());
    }
    @Test
    void move() {
        CarFerry c = new CarFerry(100, 0, Color.black,"Thanos");
        c.startEngine();
        c.move();
        assertEquals(249.9, c.getY());
    }

    @Test
    void load() {
        CarFerry c = new CarFerry(100, 0, Color.black,"Thanos");
        Car c1 = new Saab95(1,0,Color.black,3);

        c.load(c1);

        boolean test = c.getTrailer().getFirstCar().equals(c1);
        assertEquals(true, test);


    }

    @Test
    void unLoad() {
        CarFerry c = new CarFerry(100, 0, Color.black,"Thanos");
        Car c1 = new Saab95(1,0,Color.black,3);
        c.load(c1);
        assertEquals(c1, c.unLoad());
    }

    @Test
    void turnLeft() {
        CarFerry c = new CarFerry(100, 0, Color.black,"Thanos");

        c.turnLeft();

        assertEquals(Vehicle.Direction.LEFT ,c.getDirection());
    }

    @Test
    void turnRight() {
        CarFerry c = new CarFerry(100, 0, Color.black,"Thanos");
        c.turnRight();

        assertEquals(Vehicle.Direction.RIGHT ,c.getDirection());
    }

    @Test
    void getSpeedFactor() {
    }
}