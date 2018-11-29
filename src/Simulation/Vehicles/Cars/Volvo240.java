package Simulation.Vehicles.Cars;

import Simulation.Interfaces.Storeable;

import java.awt.*;

/**
 * A class describing a car of the model Volvo 240.
 */
public class Volvo240 extends Car implements Storeable {

    private final static double trimFactor = 1.25;

    public Volvo240(double enginePower, double currentSpeed, Color color, int nrDoors) {
        super(enginePower, currentSpeed, color, "Volvo240" , nrDoors);
    }

    /**
     * Decides the speedFactor by calculating enginePower and potential trimFactor.
     * @return the speedFactor.
     */
    @Override
    public double getSpeedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}