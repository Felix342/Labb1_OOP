package Simulation.Vehicles.Trucks.Flak;

import Simulation.Interfaces.Storeable;
import Simulation.Vehicles.Cars.Car;

/**
 * A type of bed which can load storeables.
 */
public class Trailer extends AbstractBed {
    private Storeable[] storeables = new Car[10];

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
        for (int i = 0; i < storeables.length; i++) {
            if(storeables[i] != null)
                storeables[i].turnLeft();
        }
    }

    public void turnRight(){
        for (int i = 0; i < storeables.length; i++) {
            if(storeables[i] != null)
                storeables[i].turnRight();
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
     * Moves all the loaded storeables to the same coordinates as the trailer.
     */
    private void moveAllChildren() {
        for (int i = 0; i < storeables.length; i++) {
            if (storeables[i] != null) {
                storeables[i].setX(getX());
                storeables[i].setY(getY());
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

            for (int i = 0; i < storeables.length; i++) {
                if (storeables[i] == c) {
                    index = i;
                    storeables[i] = null;
                    break;
                }
            }

            shiftArrLeft(storeables, index);
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
     * Adds a car to the load
     *
     * @param c is the car to be loaded
     */
    private void addCar(Storeable c) {

        for (int i = 0; i < storeables.length; i++) {
            if (storeables[i] == null) {
                storeables[i] = c;
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
        return storeables[0];
    }

    /**
     * @return the last car in load
     */
    public Storeable getLastCar() {
        Storeable storeable = null;
        for (int i = 0; i < storeables.length; i++) {
            if (storeables[i] != null) {
                storeable = storeables[i];
            }
        }
        return storeable;
    }

}
