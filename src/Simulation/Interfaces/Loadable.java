package Simulation.Interfaces;

import Simulation.Vehicles.Cars.Car;

/**
 * Describes something that can load a car.
 */
public interface Loadable extends Tiltable {
   // Car[] cars = new Car[10];
   //TODO Klura ut varför och hur? Yolo man-
    // Simulation.Vehicles.Cars.Trucks.Flak.Bed bed = null;

    /**
     * Lowers the load
     */
    void load(Car c);

    /**
     * Raises the load
     */
    Car unLoad();

    /**
     * Get x-position of the object.
     * @return
     */
    double getX();
    /**
     * Get y-position of the object.
     * @return
     */
    double getY();



}


