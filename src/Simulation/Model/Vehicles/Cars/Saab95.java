package Simulation.Model.Vehicles.Cars;

import java.awt.*;

/**
 * A class describing a car of the model Saab95.
 */
public class Saab95 extends Car {

    private boolean turboOn;

    private Saab95(double enginePower, double currentSpeed, Color color, int nrDoors) {
        super(enginePower, currentSpeed, color, "Saab95", nrDoors);
        setTurboOff();
    }

    static Saab95 createSaab95(double enginePower, double currentSpeed, Color color, int nrDoors){
        return new Saab95(enginePower, currentSpeed, color, nrDoors);
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

    /**
     *
     * @return the value of turboOn.
     */
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