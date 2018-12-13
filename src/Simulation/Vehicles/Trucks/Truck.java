package Simulation.Vehicles.Trucks;

import Simulation.Vehicles.Cars.Car;
import Simulation.Vehicles.Trucks.Flak.AbstractBed;
import Simulation.Vehicles.Trucks.Flak.Bed;

import java.awt.*;

/**
 * A type of car that has a bed.
 */
public abstract class Truck extends Car {

    protected AbstractBed bed;

    public Truck(double enginePower, double currentSpeed, Color color, String modelName, int nrDoors) {
        super(enginePower, currentSpeed, color, modelName, nrDoors);
    }

    public void setBed(AbstractBed bed) {
        this.bed = bed;
    }

    /**
     * @return speedfactor of the truck.
     */
    @Override
    public double getSpeedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Starts engine
     */
    @Override
    public void startEngine() {
        //System.out.println("Truck deg: " + bed.getDegrees());
        if (bed.getDegrees() == 70) {
            super.startEngine();
        }
    }

    /**
     * Accelerates the truck as long as degrees of its bed is not zero.
     *
     * @param amount
     */
    @Override
    public void gas(double amount) {
        if (bed.getDegrees() == 70) {
            super.gas(amount);
        }
    }

    public abstract void raiseLoad();

    public abstract void lowerLoad();


}
