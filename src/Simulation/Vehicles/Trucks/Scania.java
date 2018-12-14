package Simulation.Vehicles.Trucks;

import Simulation.Interfaces.Storeable;
import Simulation.Vehicles.Trucks.Flak.Bed;

import java.awt.*;

/**
 * A class representing a Scania truck
 */
public class Scania extends Truck implements Storeable {

    private Bed bed = new Bed(getX(), getY());

    private Scania(double enginePower, double currentSpeed, Color color, int nrDoors) {
        super(enginePower, currentSpeed, color,"Scania", nrDoors);
        setBed(bed);
    }

    public static Scania createScania(double enginePower, double currentSpeed, Color color, int nrDoors){
        return new Scania(enginePower, currentSpeed, color, nrDoors);
    }


    /**
     * @return raise the load
     */
    @Override
    public void raiseLoad() {
        bed.raiseLoad();
    }

    /**
     * @return lower the load
     */
    @Override
    public void lowerLoad() {
        bed.lowerLoad();
    }

    /**
     * Moves the scania.
     */
    @Override
    public void move() {
        super.move();
    }

}
