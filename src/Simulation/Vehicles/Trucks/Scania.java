package Simulation.Vehicles.Trucks;

import Simulation.Interfaces.Storeable;
import Simulation.Vehicles.Trucks.Flak.Bed;

import java.awt.*;

/**
 * A class representing a Scania truck
 */
public class Scania extends Truck implements Storeable {


    private Bed bed = new Bed(getX(), getY());


    public Scania(double enginePower, double currentSpeed, Color color, int nrDoors) {
        super(enginePower, currentSpeed, color,"Scania", nrDoors);
    }

    /**
     * @return raise the load
     */
    public void raiseLoad() {

        bed.raiseLoad(); //TODO sätt till 1

    }

    /**
     * @return lower the load
     */
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
