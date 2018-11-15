import java.awt.*;

/**
 * A class describing a car of the model Saab95.
 */
public class Saab95 extends Car{

    private boolean turboOn;

    public Saab95(){
        super(2, 125, Color.red, "Saab95");
        setTurboOff();
    }

    /**
     * Activates the turbo of the Saab95.
     */
    public void setTurboOn(){
        turboOn = true;
    }

    /**
     * De-activates the turbo of the Saab95.
     */
    public void setTurboOff(){
        turboOn = false;
    }

    public boolean isTurboOn() {
        return turboOn;
    }

    /**
     * Decides the speedFactor by calculating enginePower and potential turbo.
     * @return the speedFactor.
     */
    @Override
    public double getSpeedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}