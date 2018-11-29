package Simulation.Vehicles.Cars;

import Simulation.Interfaces.Storeable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * A class describing a car of the model Saab95.
 */
public class Saab95 extends Car implements Storeable {

    private boolean turboOn;

    public Saab95(double enginePower, double currentSpeed, Color color, int nrDoors) {
        super(enginePower, currentSpeed, color, "Saab95", nrDoors);
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