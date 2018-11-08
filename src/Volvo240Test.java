import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    Volvo240 volvo = new Volvo240();

    @Test
    void getSpeedFactor() {
        assertEquals(100*0.01*1.25, volvo.getSpeedFactor());
    }
}