import Simulation.Vehicles.Cars.Trucks.MANG90;
import Simulation.Vehicles.Vehicle;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {


    @Test
    void turnLeft() {
        Vehicle v = new MANG90(100, 0, Color.black,2);
        v.turnLeft();
        assertEquals(Vehicle.Direction.LEFT, v.getDirection());
    }

    @Test
    void turnRight() {
        Vehicle v = new MANG90(100, 0, Color.black,2);
        v.turnRight();
        assertEquals(Vehicle.Direction.RIGHT, v.getDirection());
    }

    @Test
    void getDirection() {
        Vehicle v = new MANG90(100, 0, Color.black,2);

        assertEquals(Vehicle.Direction.FORWARD, v.getDirection());
    }

    @Test
    void getEnginePower() {
        Vehicle v = new MANG90(100, 0, Color.black,2);

        assertEquals(100, v.getEnginePower());
    }

    @Test
    void getCurrentSpeed() {
        Vehicle v = new MANG90(100, 0, Color.black,2);

        assertEquals(0, v.getCurrentSpeed());
    }

    @Test
    void getColor() {
        Vehicle v = new MANG90(100, 0, Color.black,2);

        assertEquals(Color.black, v.getColor());
    }

    @Test
    void setColor() {
        Vehicle v = new MANG90(100, 0, Color.black,2);
        v.setColor(Color.RED);
        assertEquals(Color.red, v.getColor());
    }

    @Test
    void startEngine() {
        Vehicle v = new MANG90(100, 0, Color.black,2);
        v.startEngine();

        assertEquals(0.1, v.getCurrentSpeed());
    }

    @Test
    void stopEngine() {
        Vehicle v = new MANG90(100, 0, Color.black,2);
        v.stopEngine();

        assertEquals(0, v.getCurrentSpeed());
    }

    @Test
    void getSpeedFactor() {
        Vehicle v = new MANG90(3, 2, Color.black, 3);
        assertEquals(0.03, v.getSpeedFactor());
    }

    @Test
    void gas() {
        Vehicle v = new MANG90(3, 2, Color.black, 3);
        v.gas(0.5);
        assertEquals(2.015, v.getCurrentSpeed());
    }

    @Test
    void brake() {
        Vehicle v = new MANG90(3, 2, Color.black, 3);
        v.gas(0.5);
        assertEquals(2.015, v.getCurrentSpeed());
    }

    @Test
    void setEnginePower() {
        Vehicle v = new MANG90(3, 2, Color.black, 3);
        v.setEnginePower(5);
        assertEquals(5, v.getEnginePower());
    }

    @Test
    void getModelName() {
        Vehicle v = new MANG90(3, 2, Color.black, 3);

        assertEquals("ssd", v.getModelName());
    }

    @Test
    void setDirection() {
        Vehicle v = new MANG90(3, 2, Color.black, 3);
        v.setDirection(Vehicle.Direction.BACKWARD);
        assertEquals(Vehicle.Direction.BACKWARD, v.getDirection());
    }

    @Test
    void setX() {
        Vehicle v = new MANG90(3, 2, Color.black, 3);
        v.setX(5);
        assertEquals(5, v.getX());
    }

    @Test
    void setY() {
        Vehicle v = new MANG90(3, 2, Color.black, 3);
        v.setY(5);
        assertEquals(5, v.getY());
    }

    @Test
    void getX() {
        Vehicle v = new MANG90(3, 2, Color.black, 3);
        v.setX(5);
        assertEquals(5, v.getX());
    }

    @Test
    void getY() {
        Vehicle v = new MANG90(3, 2, Color.black,3);
        v.setY(5);
        assertEquals(5, v.getY());
    }
}