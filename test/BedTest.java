import Simulation.Vehicles.Cars.Trucks.Flak.Bed;
import Simulation.Vehicles.Cars.Trucks.MANG90;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BedTest {

    @Test
    void getDegrees() {
        MANG90 m = new MANG90(100, 0, Color.black,2);
        Bed b = new Bed(m);


        assertEquals(0 ,b.getDegrees());
    }

    @Test
    void raiseLoad() {
        MANG90 m = new MANG90(100, 0, Color.black,2);
        Bed b = new Bed(m);
        b.raiseLoad(1);


        assertEquals(1 ,b.getDegrees());
    }

    @Test
    void lowerLoad() {
        MANG90 m = new MANG90(100, 0, Color.black,2);
        Bed b = new Bed(m);
        b.lowerLoad(64);


        assertEquals(0 ,b.getDegrees());
    }
}