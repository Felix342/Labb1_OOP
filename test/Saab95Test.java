import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test {


    @Test

    void getSpeedFactor() {

        Saab95 saab = new Saab95();
        assertEquals(1.25, saab.getSpeedFactor());
    }
    @Test
    void setTurboOn(){
        Saab95 saab = new Saab95();
        saab.setTurboOn();

        assertEquals(true, saab.isTurboOn());
    }
    @Test
    void setTurboOff(){
        Saab95 saab = new Saab95();
        saab.setTurboOff();

        assertEquals(false, saab.isTurboOn());
    }
}