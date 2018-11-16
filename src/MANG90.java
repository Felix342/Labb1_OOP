import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MANG90 extends Car implements Truck {
    private double degrees = 0;
    private final Car[] cars = new Car[10];

    public MANG90(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
    }

    /**
     *
     * @return the speed factor
     */
    @Override
    public double getSpeedFactor() {
        return 0.9;
    }

    /**
     * lowers the load
     */
    @Override
    public void lowerLoad() {
        if (getCurrentSpeed() == 0) {
            degrees = 0;
        }
    }

    /**
     * rais the load
     */
    @Override
    public void raiseLoad() {
        if (getCurrentSpeed() == 0) {
            degrees = 70;
        }
    }

    /**
     * moves the Truck and the loaded cars
     */
    @Override
    public void move() {
        super.move();
        for (int i = 0; i < cars.length; i++) {
            cars[i].move();
        }
    }


    /**
     *
     * @return the degrees
     */
    public double getDegrees() {
        return degrees;
    }

    private void loadTruck(Car c) {

        if (isClose(c) && getDegrees() == 0 && !(c instanceof Truck)) {
            addCar(c);
            c.setDirection(this.getDirection());
        }

    }


    /**
     * removes a car to the load
     * @return the ofloaded car
     */
    private Car unLoadTruck() {
            Car tmp = null;
        if (getDegrees() == 0) {
            tmp = removeCar();
            tmp.turnLeft();
            tmp.move();
        }
        return tmp;
    }



    private Car removeCar() {
        Car c = null;
        for (int i = cars.length - 1; i >= 0; i--) {

            if (cars[i] != null) {
                c = cars[i];
                cars[i] = null;
                return c;
            }

        }
        return c;
    }


    /**
     * Adds a car to the load
     * @param c is the car to be loaded
     */
    private void addCar(Car c) {

        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                cars[i] = c;
                return;
            }
        }

    }

    private boolean isClose(Car c) {
        if (c.getX() - this.getX() <= 10 && c.getX() - this.getX() >= -10) {
            if (c.getY() - this.getY() <= 10 && c.getY() - this.getY() >= -10) {
                return true;
            }
        }
        return false;
    }

}
