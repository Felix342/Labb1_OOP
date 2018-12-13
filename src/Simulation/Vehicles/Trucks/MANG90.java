package Simulation.Vehicles.Trucks;

import Simulation.Interfaces.Movable;
import Simulation.Interfaces.Storeable;
import Simulation.Vehicles.Cars.Car;
import Simulation.Vehicles.Trucks.Flak.Trailer;

import java.awt.*;

/**
 * A truck of the model Mang90.
 */
public class MANG90 extends Truck {
    private Trailer trailer = new Trailer(getX(), getY());

    public MANG90(double enginePower, double currentSpeed, Color color, int nrDoors) {
        super(enginePower, currentSpeed, color, "ManG90", nrDoors);
        setBed(trailer);
    }

    /**
     * @param c is the car to be loaded onto the load
     */
    public void load(Storeable s) {
        trailer.load(s);
    }

    /**
     * unloads the last car from the load
     *
     * @return the unloaded car
     */
    public Storeable unLoad() {
        return trailer.unLoad(trailer.getLastCar());
    }

    /**
     * Turns the MANG90 and all loaded cars to the left
     */
    @Override
    public void turnLeft() {
        super.turnLeft();
        trailer.turnLeft();
    }

    /**
     * Turns the MANG90 and all loaded cars to the right
     */
    @Override
    public void turnRight() {
        super.turnRight();
        trailer.turnRight();
    }

    /**
     * lowers the load
     */
    @Override
    public void lowerLoad() {
        trailer.lowerLoad();
    }


    /**
     * raise the load
     */
    @Override
    public void raiseLoad() {
        trailer.raiseLoad();
    }

    /**
     * moves the Simulation.Vehicles.Trucks.Truck and the loaded cars
     */
    @Override
    public void move() {

        super.move();
        trailer.moveBedWithOwner(getX(), getY());

    }

    /**
     * @return the trailer of the MANG90
     */
    public Trailer getTrailer() {
        return trailer;
    }

}
