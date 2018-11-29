import Simulation.Vehicles.Cars.Volvo240;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    @Test
    void getSpeedFactor() {
        Volvo240 v = new Volvo240(3, 2, Color.black, 3);
        assertEquals(0.0375, v.getSpeedFactor());
    }
}