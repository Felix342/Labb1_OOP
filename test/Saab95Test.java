import Simulation.Vehicles.Cars.Saab95;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {


    @Test

    void getSpeedFactor() {

        Saab95 saab = new Saab95(3, 2, Color.black, 3);
        assertEquals(0.03, saab.getSpeedFactor());
    }
    @Test
    void setTurboOn(){
        Saab95 saab = new Saab95(3, 2, Color.black, 3);
        saab.setTurboOn();

        assertEquals(true, saab.isTurboOn());
    }
    @Test
    void setTurboOff(){
        Saab95 saab = new Saab95(3, 2, Color.black, 3);
        saab.setTurboOff();

        assertEquals(false, saab.isTurboOn());
    }

    @Test
    void isTurboOn() {
        Saab95 saab = new Saab95(3, 2, Color.black, 3);

        assertEquals(false, saab.isTurboOn());

    }


}