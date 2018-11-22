import java.awt.*;

public class MANG90 extends Truck implements Loadable {

    private final Car[] cars = new Car[10];
    private Trailer trailer = new Trailer(this);


    public MANG90(double enginePower, double currentSpeed, Color color, String modelName, int nrDoors) {
        super(enginePower, currentSpeed, color, modelName, nrDoors);
        setBed(trailer);
    }

    /**
     * @param c is the car to be loaded onto the load
     */
    @Override
    public void load(Car c) {
            trailer.load(c);
    }

    /**
     * unloades the last car from the load
     *
     * @return the unloaded car
     */
    @Override
    public Car unLoad() {
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
            trailer.lowerLoad(70);
        }
    }

    /**
     * rais the load
     */
    public void raiseLoad() {
        if (getCurrentSpeed() == 0) {
            trailer.raiseLoad(70);
        }
    }

    /**
     * moves the Truck and the loaded cars
     */
    @Override
    public void move() {

            super.move();
            trailer.moveAllChildren();

    }

}
