package Simulation.Vehicles.Trucks.Flak;

import Simulation.Interfaces.Movable;
import Simulation.Interfaces.Storeable;
import Simulation.Vehicles.Cars.Car;

/**
 * A type of bed which can load cars.
 */
public class Trailer extends AbstractBed {
    private Storeable[] cars = new Car[10];

    public Trailer(double x, double y) {
        super(x, y);
    }

    /**
     * loads a car to the truck
     *
     * @param c the car to be loaded
     */
    public void load(Storeable c) {

        if (c instanceof Storeable && isClose(c) && getDegrees() == 0 && !c.isLoaded()) {
            addCar(c);
            c.setLoaded(true);
        }

    }


    public void turnLeft(){
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] != null)
                cars[i].turnLeft();
        }
    }

    public void turnRight(){
        for (int i = 0; i < cars.length; i++) {
            if(cars[i] != null)
                cars[i].turnRight();
        }
    }


    /**
     * Raise the load
     */
    public void raiseLoad() {
        super.raiseLoad(70);
    }

    /**
     * Lower the load
     */
    public void lowerLoad() {
        super.lowerLoad(70);
    }

    @Override
    public void moveBedWithOwner(double x, double y){
        setX(x);
        setY(y);
        moveAllChildren();
    }

    /**
     * Moves all the loaded cars to the same coordinates as the trailer.
     */
    private void moveAllChildren() {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                cars[i].setX(getX());
                cars[i].setY(getY());
            }

        }
    }

    /**
     * unloads a car
     *
     * @return the offloaded car
     */
    public Storeable unLoad(Storeable c) {
        if (getDegrees() == 0) {
            int index = 0;

            for (int i = 0; i < cars.length; i++) {
                if (cars[i] == c) {
                    index = i;
                    cars[i] = null;
                    break;
                }
            }

            shiftArrLeft(cars, index);
            c.setLoaded(false);
            return c;
        }
        return null;
    }

    /**
     * @param c the car to check the distance to
     * @return wether or not the given car is close enough to be loaded
     */
    private boolean isClose(Storeable c) {
        if (c.getX() - getX() <= 10 && c.getX() - getX() >= -10) {
            if (c.getY() - getY() <= 10 && c.getY() - getY() >= -10) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the cars loaded on the trailer
     */
    public Storeable[] getCars() {
        return cars;
    }


    /**
     * Adds a car to the load
     *
     * @param c is the car to be loaded
     */
    private void addCar(Storeable c) {

        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                cars[i] = c;
                c.setX(getX());
                c.setY(getY());
                return;
            }
        }

    }

    /**
     * Shifts the given array as far to the right as possible
     *
     * @param cars  the array to be shifted
     * @param index
     */
    private void shiftArrLeft(Storeable[] cars, int index) {

        for (int i = index + 1; i < cars.length; i++) {
            cars[i - 1] = cars[i];
        }
        cars[cars.length - 1] = null;

    }

    /**
     * @return the first car in load
     */
    public Storeable getFirstCar() {
        return cars[0];
    }

    /**
     * @return the last car in load
     */
    public Storeable getLastCar() {
        Storeable car = null;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                car = cars[i];
            }
        }
        return car;
    }

}
