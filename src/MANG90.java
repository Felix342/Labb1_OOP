import java.awt.*;

public class MANG90 extends Car implements Loadable, Tiltable {
    private boolean raised = false;
    private final Car[] cars = new Car[10];
    private Trailer trailer = new Trailer();

    public MANG90(int nrDoors, double enginePower, Color color) {
        super(nrDoors, enginePower, color, "MAN G90");
    }

    /**
     *
     * @param c is the car to be loaded onto the load
     */
    @Override
    public void load(Car c) {
        if(!raised){
            trailer.load(c);
        }
    }

    /**
     * unloades the last car from the load
     * @return the unloaded car
     */
    @Override
    public Car unLoad(Car c) {
        return trailer.unLoad(trailer.getLastCar());
    }

    /**
     * turns this and all cas in it to the left
     */
    @Override
    public void turnLeft() {
        super.turnLeft();
        for (int i = 0; i < cars.length; i++) {
            cars[i].turnLeft();
        }
    }

    /**
     * turns this and all cas in it to the right
     */
    @Override
    public void turnRight() {
        super.turnRight();
        for (int i = 0; i < cars.length; i++) {
            cars[i].turnRight();
        }
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
    public void lowerLoad() {
        if (getCurrentSpeed() == 0) {
            raised = false;
        }
    }

    /**
     * rais the load
     */
    public void raiseLoad() {
        if (getCurrentSpeed() == 0) {
            raised = true;
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

    private boolean isClose(Car c) {
        if (c.getX() - this.getX() <= 10 && c.getX() - this.getX() >= -10) {
            if (c.getY() - this.getY() <= 10 && c.getY() - this.getY() >= -10) {
                return true;
            }
        }
        return false;
    }

}
