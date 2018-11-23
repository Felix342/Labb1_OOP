package Simulation.Vehicles.Cars.Trucks;

import Simulation.Interfaces.Tiltable;
import Simulation.Vehicles.Cars.Car;
import Simulation.Vehicles.Cars.Trucks.Flak.Bed;

import java.awt.*;

/**
 * A type of car that has a bed.
 */
public abstract class Truck extends Car implements Tiltable {

    private Bed bed;

    public Truck(double enginePower, double currentSpeed, Color color, String modelName, int nrDoors) {
        super(enginePower, currentSpeed, color, modelName, nrDoors);


    }

    /**
     *
     * @return speedfactor of the truck.
     */
    @Override
    public double getSpeedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Accelerates the truck as long as degrees of its bed is not zero.
     * @param amount
     */
    @Override
    public void gas(double amount) {
        if(bed.getDegrees() == 0) {
            super.gas(amount);
        }
    }

    /**
     * sets the instance of the bed.
     * @param bed sets local instance of bed to its value.
     */
    public void setBed(Bed bed) {
        this.bed = bed;
    }

    public Bed getBed(){
        return bed;
    }

    /**
     * @return the current degree of the tilt of the load
     */
    @Override
    public double getDegrees() {
        return bed.getDegrees();
    }



}
