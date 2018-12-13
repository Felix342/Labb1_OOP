import Simulation.Vehicles.Cars.Car;
import Simulation.Vehicles.Cars.Trucks.MANG90;
import Simulation.Vehicles.Cars.Saab95;
import Simulation.Vehicles.Cars.Trucks.Flak.Trailer;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class TrailerTest {

    @Test
    void load() {
        MANG90 m = new MANG90(100, 0, Color.black,2);
        Car c = new Saab95(1,0,Color.black,3);

        m.load(c);

        boolean test = m.getTrailer().getFirstCar().equals(c);
        assertEquals(true, test);
    }

    @Test
    void moveAllChildren() {
        MANG90 m = new MANG90(100, 0, Color.black,2);
        Car c = new Saab95(1,0,Color.black,3);
        m.startEngine();
        m.load(c);

        Trailer t = m.getTrailer();
        m.move();

        Car[] cs = t.getCars();

        assertEquals(249.9, cs[0].getY());

    }

    @Test
    void unLoad() {
        MANG90 m = new MANG90(100, 0, Color.black,2);
        Car c = new Saab95(1,0,Color.black,3);
        m.load(c);
        assertEquals(c, m.unLoad());
    }

    @Test
    void getFirstCar() {
        MANG90 m = new MANG90(100, 0, Color.black,2);
        Car c = new Saab95(1,0,Color.black,3);
        Trailer t = m.getTrailer();
        m.load(c);
        assertEquals(c, t.getFirstCar());
    }

    @Test
    void getLastCar() {
        MANG90 m = new MANG90(100, 0, Color.black,2);
        Car c = new Saab95(1,0,Color.black,3);
        Trailer t = m.getTrailer();
        m.load(c);
        assertEquals(c, t.getLastCar());
    }
}