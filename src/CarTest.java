import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car = new Volvo240();
    @Test
    void getX() {
        assertEquals(250, car.getX());
    }

    @Test
    void getY() {
        assertEquals(250, car.getY());
    }

    @Test
    void getNrDoors() {
        assertEquals(4, car.getNrDoors());
    }

    @Test
    void getEnginePower() {
        assertEquals(100, car.getEnginePower());
    }

    @Test
    void getCurrentSpeed() {assertEquals(0, car.getCurrentSpeed());

    }

    @Test
    void getColor() {
        assertEquals(Color.black, car.getColor());
    }
}