package Simulation.Vehicles.Cars.Trucks;

import Simulation.Interfaces.Storeable;
import Simulation.Vehicles.Cars.Trucks.Flak.Bed;

import java.awt.*;

/**
 * A class representing a Scania truck
 */
public class Scania extends Truck implements Storeable {


    //private Bed bed = new Bed(this);


    public Scania(double enginePower, double currentSpeed, Color color, int nrDoors) {
        super(enginePower, currentSpeed, color,"Scania", nrDoors);
        setBed(new Bed(this));
    }

    /**
     * @return raise the load
     */
    public void raiseLoad() {

        getBed().raiseLoad(10); //TODO sätt till 1

    }

    /**
     * @return lower the load
     */
    public void lowerLoad() {
        getBed().lowerLoad(10);
    }

    /**
     * Moves the scania.
     */
    @Override
    public void move() {
        super.move();
    }

}
