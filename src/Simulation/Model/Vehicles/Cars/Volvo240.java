package Simulation.Model.Vehicles.Cars;

import java.awt.*;

/**
 * A class describing a car of the model Volvo 240.
 */
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    private Volvo240(double enginePower, double currentSpeed, Color color, int nrDoors) {
        super(enginePower, currentSpeed, color, "Volvo240" , nrDoors);
    }

    static Volvo240 createVolvo240(double enginePower, double currentSpeed, Color color, int nrDoors){
        return new Volvo240(enginePower, currentSpeed, color, nrDoors);
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