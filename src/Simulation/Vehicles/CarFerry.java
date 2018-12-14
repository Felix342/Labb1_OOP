package Simulation.Vehicles;

import Simulation.Interfaces.Storeable;
import Simulation.Vehicles.Trucks.Flak.Trailer;

import java.awt.*;

/**
 * A Ferry which can hold cars.
 */
public class CarFerry extends Vehicle {
    private Trailer trailer = new Trailer(getX(), getY());


    private CarFerry(double enginePower, double currentSpeed, Color color) {
        super(enginePower, currentSpeed, color, "CarFerry");
    }

    public static CarFerry createCarFerry(double enginePower, double currentSpeed, Color color){
        return new CarFerry(enginePower, currentSpeed, color);
    }

    /**
     * loads a car to the ferry
     *
     * @param s the car to be loaded
     */
    public void load(Storeable s) {
        trailer.load(s);
    }

    /**
     * @return the unloaded car
     */
    public Storeable unLoad() {
        return trailer.unLoad(trailer.getFirstCar());
    }

    /**
     * moves the CarFerry and the loaded cars
     */
    @Override
    public void move() {
        if (trailer.getDegrees() == 70) {
            super.move();
            trailer.moveBedWithOwner(getX(), getY());
        }
    }

    /**
     * lowers the load
     */
    public void lowerLoad() {
        trailer.lowerLoad();
    }

    /**
     * raise the load
     */
    public void raiseLoad() {
        trailer.raiseLoad();
    }

    /**
     * @return the speedfactor of the carferry.
     */
    @Override
    public double getSpeedFactor() {
        return getEnginePower() * 0.01;
    }
}
